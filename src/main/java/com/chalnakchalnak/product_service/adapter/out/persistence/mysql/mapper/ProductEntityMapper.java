package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    public ProductEntity toEntity(ProductSaveDto productSaveDto) {
        return ProductEntity.builder()
                .productUuid(productSaveDto.getProductUuid())
                .saleMemberUuid()
                .title()
                .categoryId(productSaveDto.getCategoryId())
                .description(productSaveDto.getDescription())
                .productCondition(productSaveDto.getProductCondition())
                .isDirectDeal(productSaveDto.getIsDirectDeal())
                .directDealLocation(productSaveDto.getDirectDealLocation())
                .isHide(false)
                .status()
                .thumbnailUrl()
                .viewCount(0)
                .price(productSaveDto.getPrice())
                .build();
    }
}
