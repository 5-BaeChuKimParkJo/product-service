package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import org.springframework.stereotype.Component;

@Component
public class ProductImageEntityMapper {

    public ProductImageEntity toEntity(ProductImageUrlSaveDto productImageUrlSaveDto) {
        return ProductImageEntity.builder()
                .key(productImageUrlSaveDto.getKey())
                .productUuid(productImageUrlSaveDto.getProductUuid())
                .order(productImageUrlSaveDto.getOrder())
                .build();
    }
}
