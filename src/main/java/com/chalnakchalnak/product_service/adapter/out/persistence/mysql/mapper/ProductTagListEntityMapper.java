package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductTagListEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListSaveDto;
import org.springframework.stereotype.Component;

@Component
public class ProductTagListEntityMapper {

    public ProductTagListEntity toEntity(ProductTagListSaveDto productTagCreateSaveDto) {
        return ProductTagListEntity.builder()
                .productUuid(productTagCreateSaveDto.getProductUuid())
                .tagId(productTagCreateSaveDto.getTagId())
                .idx(productTagCreateSaveDto.getIdx())
                .build();
    }
}
