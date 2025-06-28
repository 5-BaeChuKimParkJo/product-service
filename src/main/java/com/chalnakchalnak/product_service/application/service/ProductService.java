package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.in.vo.Image;
import com.chalnakchalnak.product_service.adapter.out.event.ProductCreateEvent;
import com.chalnakchalnak.product_service.adapter.out.event.ProductDeleteEvent;
import com.chalnakchalnak.product_service.adapter.out.event.ProductUpdateEvent;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.*;
import com.chalnakchalnak.product_service.application.mapper.PresignedUrlServiceMapper;
import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.*;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductTagListRepositoryPort productTagListRepositoryPort;
    private final ProductServiceMapper productServiceMapper;
    private final PresignedUrlServiceMapper presignedUrlServiceMapper;
    private final ApplicationEventPublisher publisher;

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        return productServiceMapper.from(productRepositoryPort.getProduct(productUuid));
    }

    @Override
    public List<ProductResponseDto> getProductList(ProductUuidListRequestDto productUuidListRequestDto) {

        if (productUuidListRequestDto.getProductUuidList().size() == 0) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_GET_DATA);
        }

        return productUuidListRequestDto.getProductUuidList()
                .stream()
                .map(productUuid -> productServiceMapper.from(productRepositoryPort.getProduct(productUuid)))
                .toList();
    }

    @Override
    public List<ProductResponseDto> getAllProductList() {
        return productRepositoryPort.getAllProduct()
                .stream()
                .map(productDomain -> productServiceMapper.from(productDomain))
                .toList();
    }

    @Override
    public List<ProductResponseDto> getHideProductList(String memberUuid) {
        return productRepositoryPort.getHideProductList(memberUuid)
                .stream()
                .map(productDomain -> productServiceMapper.from(productDomain))
                .toList();
    }

    @Override
    @Transactional
    public String createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productCreateRequestDto);
        // 이미지가 있는 경우는 썸네일 지정: 0번째 사진
        if(!productDomain.getImageList().isEmpty()) {
            productDomain.setThumbnailKey(0);
        }
        productDomain.setZeroVeiw();
        productDomain.setIsHide(false);
        productDomain.setStatus(Status.ACTIVE);
        productRepositoryPort.createProduct(productServiceMapper.toProductSaveDto(productDomain));

        // 이미지 업로드
        uploadImageList(productDomain);

        // 태그 추가
        addTags(productDomain);

        // 이벤트 발행
        publisher.publishEvent(new ProductCreateEvent(productRepositoryPort.getProductForOutbox(productCreateRequestDto.getProductUuid())));

        return productDomain.getProductUuid();
    }

    @Override
    @Transactional
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productUpdateRequestDto);

        productRepositoryPort.updateProduct(productServiceMapper.toUpdateSaveDto(productDomain));

        if (productUpdateRequestDto.getImages() != null) {

            // 요청되지 않은 productUuid&&order 삭제하기
            deleteNotContainsImage(productUpdateRequestDto);

            for (Image images : productUpdateRequestDto.getImages()) {
                Optional<ProductImageEntity> optionalProductImage = productImageRepositoryPort
                        .getImageUrl(productUpdateRequestDto.getProductUuid(), images.getOrder());

                // 상품uuid && 순서 존재 -> update
                if (optionalProductImage.isPresent()) {
                    productImageRepositoryPort
                            .updateImageKey(presignedUrlServiceMapper
                                                    .toProductImageUrlSaveDto(images.getKey(),
                                                                                productUpdateRequestDto.getProductUuid(),
                                                                                images.getOrder()));
                }
                // insert
                else {
                    productImageRepositoryPort
                            .uploadImageKey(presignedUrlServiceMapper.toProductImageUrlSaveDto(images.getKey(),
                                                                                                productUpdateRequestDto.getProductUuid(),
                                                                                                images.getOrder()));
                }
            }
        }

        // 태그 삭제
        deleteAllTags(productUpdateRequestDto.getProductUuid());

        // 태그 추가
        addTags(productDomain);

        // 이벤트 발행
        publisher.publishEvent(new ProductUpdateEvent(productRepositoryPort.getProductForOutbox(productUpdateRequestDto.getProductUuid())));
    }

    @Override
    @Transactional
    public void deleteProduct(String productUuid) {

        if (!productRepositoryPort.exists(productUuid)) {
            throw new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT);
        }

        // 상품 소프트 딜리트
        productRepositoryPort.softDeleteProduct(productUuid);

        // 이벤트 발행
        publisher.publishEvent(new ProductDeleteEvent(productRepositoryPort.getProductId(productUuid)));
    }

    private void uploadImageList(ProductDomain productDomain) {
        if (productDomain.getImageList() != null) {
            int idx = productImageRepositoryPort.getMaxImageIdx(productDomain.getProductUuid());
            for (Image image : productDomain.getImageList()) {
                productImageRepositoryPort
                        .uploadImageKey(ProductImageUrlSaveDto.builder()
                                .productUuid(productDomain.getProductUuid())
                                .key(image.getKey())
                                .order(idx++)
                                .build());
            }
        }
    }

    private void deleteAllTags(String productUuid) {
        productTagListRepositoryPort.deleteAllTagIdByProductUuid(productUuid);
    }

    private void addTags(ProductDomain productDomain) {
        // 태그 존재 시
        if (productDomain.getTagIdList() != null) {
            AtomicInteger idx = new AtomicInteger(0);
            productDomain.getTagIdList()
                    .stream()
                    .map(tagId -> ProductTagListSaveDto.builder()
                                    .productUuid(productDomain.getProductUuid())
                                    .tagId(tagId)
                                    .idx(idx.incrementAndGet())
                                    .build())
                    .forEach(productTagCreateSaveDto
                            -> productTagListRepositoryPort.createProductTagList(productTagCreateSaveDto));
        }
    }

    // 요청되지 않은 productUuid&&order 삭제하기
    private void deleteNotContainsImage(ProductUpdateRequestDto productUpdateRequestDto) {
        List<Integer> requestedOrderList = productUpdateRequestDto.getImages()
                .stream()
                .map(images -> images.getOrder())
                .toList();
        List<Integer> savedOrderList = productImageRepositoryPort.getImageUrlList(productUpdateRequestDto.getProductUuid())
                .stream()
                .map(productImageEntity -> productImageEntity.getOrder())
                .toList();

        List<Integer> deletedImageKeys = savedOrderList.stream()
                .filter(savedKey -> !requestedOrderList.contains(savedKey))
                .toList();

        //  썸네일 삭제 불가능
        if (deletedImageKeys.contains(1)) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_DELETE_THUMBNAIL);
        }

        deletedImageKeys
                .stream()
                .forEach(order -> productImageRepositoryPort
                                                .deleteImageKey(productUpdateRequestDto.getProductUuid(), order));
    }

}
