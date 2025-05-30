package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.application.mapper.ProductServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductServiceMapper productServiceMapper;

    @Override
    public void createProduct(ProductRequestDto productRequestDto) {

        ProductDomain productDomain = productServiceMapper.toProductDomain(productRequestDto);
        productDomain.setThumbnailUrl(0);

        productRepositoryPort.createProduct(productServiceMapper.toProductSaveDto(productDomain));
    }
}
