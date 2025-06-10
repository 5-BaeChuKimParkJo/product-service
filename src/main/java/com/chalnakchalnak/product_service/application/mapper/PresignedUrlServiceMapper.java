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
                .uploadFileUrl(saveImageUrlRequestDto.getUploadFileUrl())
                .productUuid(saveImageUrlRequestDto.getProductUuid())
                .idx(saveImageUrlRequestDto.getIdx())
                .build();
    }

    public ProductImageUrlSaveDto toProductImageUrlSaveDto(ProductImageDomain productImageDomain) {
        return ProductImageUrlSaveDto.builder()
                .uploadFileUrl(productImageDomain.getUploadFileUrl())
                .productUuid(productImageDomain.getProductUuid())
                .idx(productImageDomain.getIdx())
                .build();
    }

    public ProductImageEntity toEntity(ProductImageUrlSaveDto productImageUrlSaveDto) {
        return ProductImageEntity.builder()
                .image_url(productImageUrlSaveDto.getUploadFileUrl())
                .productUuid(productImageUrlSaveDto.getProductUuid())
                .idx(productImageUrlSaveDto.getIdx())
                .build();
    }
}
