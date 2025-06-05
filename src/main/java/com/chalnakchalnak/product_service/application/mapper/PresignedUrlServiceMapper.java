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
                .presignedUrl(saveImageUrlRequestDto.getPresignedUrl())
                .uploadFileUrl(saveImageUrlRequestDto.getUploadFileUrl())
                .productUuid(saveImageUrlRequestDto.getProductUuid())
                .build();
    }

    public ProductImageUrlSaveDto toProductImageUrlSaveDto(ProductImageDomain productImageDomain) {
        return ProductImageUrlSaveDto.builder()
                .presignedUrl(productImageDomain.getPresignedUrl())
                .uploadFileUrl(productImageDomain.getUploadFileUrl())
                .productUuid(productImageDomain.getProductUuid())
                .build();
    }

    public ProductImageEntity toEntity(ProductImageUrlSaveDto productImageUrlSaveDto) {
        return ProductImageEntity.builder()
                .presignedUrl(productImageUrlSaveDto.getPresignedUrl())
                .uploadFileUrl(productImageUrlSaveDto.getUploadFileUrl())
                .productUuid(productImageUrlSaveDto.getProductUuid())
                .index(productImageUrlSaveDto.getIndex())
                .build();
    }
}
