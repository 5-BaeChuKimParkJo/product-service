package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductTagListEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.*;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper objectMapper;

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        return productServiceMapper.from(productRepositoryPort.getProduct(productUuid));
    }

    @Override
    public List<ProductResponseDto> getProductList(ProductUuidListRequestDto productUuidListRequestDto) {
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
    public void createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productCreateRequestDto);
        // 이미지가 있는 경우는 썸네일 지정: 0번째 사진
        if(!productDomain.getProductImageKeyList().isEmpty()) {
            productDomain.setThumbnailKey(0);
        }
        productDomain.setIsHide(false);
        productDomain.setStatus(Status.ACTIVE);
        productRepositoryPort.createProduct(productServiceMapper.toProductSaveDto(productDomain));

        // 이미지 업로드
        uploadImageList(productDomain);

        // 태그 추가
        addTag(productDomain);
    }

    @Override
    @Transactional
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productUpdateRequestDto);

        productRepositoryPort.updateProduct(productServiceMapper.toUpdateSaveDto(productDomain));

        // 이미지 없로드
        uploadImageList(productDomain);

        // 태그 삭제
        deleteTag(productDomain);
        
        // 태그 추가
        addTag(productDomain);
    }

    @Override
    @Transactional
    public void deleteProduct(String productUuid) {

        // 상품 소프트 딜리트
        productRepositoryPort.softDeleteProduct(productUuid);
    }


    private void uploadImageList(ProductDomain productDomain) {
        if (productDomain.getProductImageKeyList() != null) {
            int idx = 0;
            for (String imageKey : productDomain.getProductImageKeyList()) {
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
