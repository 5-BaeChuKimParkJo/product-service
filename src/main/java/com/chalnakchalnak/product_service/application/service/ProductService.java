package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductServiceMapper productServiceMapper;

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        return productRepositoryPort.getProduct(productUuid);
    }

    @Override
    public void createProduct(ProductCreateRequestDto productRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productRequestDto);
        // 이미지가 있는 경우는 썸네일 지정: 0번째 사진
        if(!productDomain.getProductImageUrList().isEmpty()) {
            productDomain.setThumbnailUrl(0);
        }
        productRepositoryPort.createProduct(productServiceMapper.toProductSaveDto(productDomain));
    }

    @Override
    public void updateProduct(ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDomain productDomain = productServiceMapper.toProductDomain(productUpdateRequestDto);
        if (!productDomain.getIsDirectDeal()) {
            productDomain.cancelDirectDeal();
        }
        productRepositoryPort.updateProduct(productServiceMapper.toUpdateRequestDto(productDomain));
    }

    @Override
    public void deleteProduct(String productUuid) {
        productRepositoryPort.deleteProduct(productUuid);
    }
}
