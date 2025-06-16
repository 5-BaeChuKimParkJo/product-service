package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.domain.ProductImageDomain;
import org.springframework.stereotype.Component;

@Component
public class PresignedUrlServiceMapper {

    public ProductImageDomain toProductImageDomain(SaveImageUrlRequestDto saveImageUrlRequestDto) {
        return ProductImageDomain.builder()
                .imageKey(saveImageUrlRequestDto.getImageKey())
                .productUuid(saveImageUrlRequestDto.getProductUuid())
                .idx(saveImageUrlRequestDto.getIdx())
                .build();
    }

    public ProductImageUrlSaveDto toProductImageUrlSaveDto(ProductImageDomain productImageDomain) {
        return ProductImageUrlSaveDto.builder()
                .imageKey(productImageDomain.getImageKey())
                .productUuid(productImageDomain.getProductUuid())
                .idx(productImageDomain.getIdx())
                .build();
    }

    public ProductImageEntity toEntity(ProductImageUrlSaveDto productImageUrlSaveDto) {
        return ProductImageEntity.builder()
                .imageKey(productImageUrlSaveDto.getImageKey())
                .productUuid(productImageUrlSaveDto.getProductUuid())
                .idx(productImageUrlSaveDto.getIdx())
                .build();
    }
}
