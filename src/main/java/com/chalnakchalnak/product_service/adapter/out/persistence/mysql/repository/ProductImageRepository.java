package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductImageEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductImageRepository implements ProductImageRepositoryPort {

    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductImageEntityMapper productImageEntityMapper;

    @Override
    public void uploadImageUrl(ProductImageUrlSaveDto productImageUrlSaveDto) {
        productImageJpaRepository.save(productImageEntityMapper.toEntity(productImageUrlSaveDto));
    }
}
