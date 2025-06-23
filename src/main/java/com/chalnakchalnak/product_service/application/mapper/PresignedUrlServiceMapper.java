package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.ImageUrl;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.domain.ProductImageDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PresignedUrlServiceMapper {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    public ProductImageDomain toProductImageDomain(SaveImageUrlRequestDto saveImageUrlRequestDto) {
        return ProductImageDomain.builder()
                .key(saveImageUrlRequestDto.getImageKey())
                .productUuid(saveImageUrlRequestDto.getProductUuid())
                .order(saveImageUrlRequestDto.getIdx())
                .build();
    }

    public ProductImageUrlSaveDto toProductImageUrlSaveDto(ProductImageDomain productImageDomain) {
        return ProductImageUrlSaveDto.builder()
                .key(productImageDomain.getKey())
                .productUuid(productImageDomain.getProductUuid())
                .order(productImageDomain.getOrder())
                .build();
    }

    public ProductImageEntity toEntity(ProductImageUrlSaveDto productImageUrlSaveDto) {
        return ProductImageEntity.builder()
                .key(productImageUrlSaveDto.getKey())
                .productUuid(productImageUrlSaveDto.getProductUuid())
                .order(productImageUrlSaveDto.getOrder())
                .build();
    }

    public ImageUrl toImageUrl(ProductImageEntity productImageEntity) {
        return ImageUrl.builder()
                .productImageId(productImageEntity.getId())
                .url(setUrl(productImageEntity.getKey()))
                .order(productImageEntity.getOrder())
                .build();
    }


    private String setUrl(String key) {
        return  !"".equals(key) && key != null ?
                "https://" + bucket + ".s3." + region + ".amazonaws.com/" + key : null;
    }
}
