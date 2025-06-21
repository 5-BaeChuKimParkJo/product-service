package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.out.kafka.KafkaPort;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.*;
import com.chalnakchalnak.product_service.application.mapper.OutboxServiceMapper;
import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.*;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductTagListRepositoryPort productTagListRepositoryPort;
    private final OutboxRepositoryPort outboxRepositoryPort;
    private final ProductServiceMapper productServiceMapper;
    private final OutboxServiceMapper outboxServiceMapper;
    private final KafkaPort kafkaPort;

    private final String productServiceOutbox = "product-service.outbox";

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
    @Transactional
    public String createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productCreateRequestDto);
        // 이미지가 있는 경우는 썸네일 지정: 0번째 사진
        if(!productDomain.getImageKeyList().isEmpty()) {
            productDomain.setThumbnailKey(0);
        }
        productDomain.setIsHide(false);
        productDomain.setStatus(Status.ACTIVE);
        ProductEntity productEntity = productRepositoryPort
                                            .createProduct(productServiceMapper.toProductSaveDto(productDomain));

        // 이미지 업로드
        uploadImageList(productDomain);

        // 태그 추가
        addTag(productDomain);


        OutboxEntity outboxEntity = null;
        // 아웃박스 저장
        try {
            outboxEntity = outboxRepositoryPort.saveEvent(outboxServiceMapper.toOutboxSaveDto(productDomain,
                                                                                AggregateType.PRODUCT,
                                                                                productEntity.getId(),
                                                                                EventType.PRODUCT_CREATE,
                                                                                Op.C));
        } catch (JsonProcessingException e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE_OUTBOX);
        }

        try {
            kafkaPort.productEvent(productServiceOutbox, outboxEntity);
        } catch (JsonProcessingException e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SEND_MESSAGE);
        }

        return productDomain.getProductUuid();
    }

    @Override
    @Transactional
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productUpdateRequestDto);

        productRepositoryPort.updateProduct(productServiceMapper.toUpdateSaveDto(productDomain));

        // 이미지 없로드
        uploadImageList(productDomain);

//        // 태그 삭제
//        deleteTag(productDomain);
//
//        // 태그 추가
//        addTag(productDomain);


    }

    @Override
    @Transactional
    public void deleteProduct(String productUuid) {

        // 상품 소프트 딜리트
        productRepositoryPort.softDeleteProduct(productUuid);

        ProductDomain productDomain = productRepositoryPort.getProduct(productUuid);

    }


    private void uploadImageList(ProductDomain productDomain) {
        if (productDomain.getImageKeyList() != null) {
            int idx = 0;
            for (String imageKey : productDomain.getImageKeyList()) {
                productImageRepositoryPort
                        .uploadImageKey(ProductImageUrlSaveDto.builder()
                                .productUuid(productDomain.getProductUuid())
                                .imageKey(imageKey)
                                .idx(++idx).build());
            }


        }
    }

    private void deleteTag(ProductDomain productDomain) {
        // 태그 존재 시
        if (productDomain.getTagIdList() != null) {
            productTagListRepositoryPort.getProductTagListByProductUuid(productDomain.getProductUuid())
                    .stream()
                    .forEach(productTagListEntity ->
                            productTagListRepositoryPort.deleteProductTagList(productTagListEntity));

        }
    }

    private void addTag(ProductDomain productDomain) {
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

}
