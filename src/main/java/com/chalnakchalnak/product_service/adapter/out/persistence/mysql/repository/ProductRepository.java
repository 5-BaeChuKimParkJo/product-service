package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public ProductResponseDto getProductPreview(String productUuid) {
        return null;
    }

    @Override
    public List<ProductResponseDto> getProductPreviewList() {
        return List.of();
    }

    @Override
    public void createProduct(ProductSaveDto productSaveDto) {
        productJpaRepository.save(productEntityMapper.toEntity(productSaveDto));
    }
}
