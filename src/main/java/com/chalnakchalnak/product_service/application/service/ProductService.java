package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductServiceMapper productServiceMapper;

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        return productRepositoryPort.getProduct(productUuid);
    }

    @Override
    @Transactional
    public void createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productCreateRequestDto);
        // 이미지가 있는 경우는 썸네일 지정: 0번째 사진
        if(!productDomain.getProductImageUrList().isEmpty()) {
            productDomain.setThumbnailUrl(0);
        }
        productDomain.setIsHide(false);
        productDomain.setStatus(Status.ACTIVE);
        productRepositoryPort.createProduct(productServiceMapper.toProductSaveDto(productDomain));

        // 이미지 저장
        int idx = 0;
        for (String upload_file_url : productDomain.getProductImageUrList()) {
            productImageRepositoryPort
                    .uploadImageUrl(ProductImageUrlSaveDto.builder()
                                                        .productUuid(productDomain.getProductUuid())
                                                        .uploadFileUrl(upload_file_url)
                                                        .idx(idx++).build());
        }

    }

    @Override
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productUpdateRequestDto);
        productRepositoryPort.updateProduct(productServiceMapper.toUpdateSaveDto(productDomain));
    }

    @Override
    public void deleteProduct(String productUuid) {
        productRepositoryPort.deleteProduct(productUuid);
    }
}
