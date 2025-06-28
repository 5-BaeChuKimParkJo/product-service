package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.ImageUrl;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductEntityMapper {

    public ProductResponseDto toProductResponseDto(ProductEntity productEntity) {
        return ProductResponseDto.builder()
                .productUuid(productEntity.getProductUuid())
                .saleMemberUuid(productEntity.getSaleMemberUuid())
                .title(productEntity.getTitle())
                .categoryId(productEntity.getCategoryId())
                .description(productEntity.getDescription())
                .productCondition(productEntity.getProductCondition())
                .isDirectDeal(productEntity.getIsDirectDeal())
                .directDealLocation(productEntity.getDirectDealLocation())
                .isHide(productEntity.getIsHide())
                .status(productEntity.getStatus())
                .thumbnailKey(productEntity.getThumbnailKey())
                .viewCount(productEntity.getViewCount())
                .price(productEntity.getPrice())
                .ticketUuid(productEntity.getTicketUuid())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }

    public ProductEntity toEntity(ProductCreateSaveDto productSaveDto) {
        return ProductEntity.builder()
                .productUuid(productSaveDto.getProductUuid())
                .saleMemberUuid(productSaveDto.getSaleMemberUuid())
                .title(productSaveDto.getTitle())
                .categoryId(productSaveDto.getCategoryId())
                .description(productSaveDto.getDescription())
                .productCondition(productSaveDto.getProductCondition())
                .isDirectDeal(productSaveDto.getIsDirectDeal())
                .directDealLocation(productSaveDto.getDirectDealLocation())
                .isHide(productSaveDto.getIsHide())
                .status(productSaveDto.getStatus())
                .thumbnailKey(productSaveDto.getThumbnailKey())
                .viewCount(productSaveDto.getViewCount())
                .price(productSaveDto.getPrice())
                .ticketUuid(productSaveDto.getTicketUuid())
                .isDeleted(false)
                .build();
    }

    public ProductDomain from(ProductEntity productEntity, List<ImageUrl> imageUrlList, List<Long> tagIdList) {
        return ProductDomain.builder()
                .id(productEntity.getId())
                .productUuid(productEntity.getProductUuid())
                .saleMemberUuid(productEntity.getSaleMemberUuid())
                .title(productEntity.getTitle())
                .categoryId(productEntity.getCategoryId())
                .description(productEntity.getDescription())
                .productCondition(productEntity.getProductCondition())
                .isDirectDeal(productEntity.getIsDirectDeal())
                .directDealLocation(productEntity.getDirectDealLocation())
                .isHide(productEntity.getIsHide())
                .status(productEntity.getStatus())
                .thumbnailKey(productEntity.getThumbnailKey())
                .viewCount(productEntity.getViewCount())
                .price(productEntity.getPrice())
                .ticketUuid(productEntity.getTicketUuid())
                .imageUrlList(imageUrlList)
                .tagIdList(tagIdList)
                .isDeleted(productEntity.getIsDeleted())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }

    public ProductDomain from(ProductEntity productEntity) {
        return ProductDomain.builder()
                .productUuid(productEntity.getProductUuid())
                .saleMemberUuid(productEntity.getSaleMemberUuid())
                .title(productEntity.getTitle())
                .categoryId(productEntity.getCategoryId())
                .description(productEntity.getDescription())
                .productCondition(productEntity.getProductCondition())
                .isDirectDeal(productEntity.getIsDirectDeal())
                .directDealLocation(productEntity.getDirectDealLocation())
                .isHide(productEntity.getIsHide())
                .status(productEntity.getStatus())
                .thumbnailKey(productEntity.getThumbnailKey())
                .viewCount(productEntity.getViewCount())
                .price(productEntity.getPrice())
                .ticketUuid(productEntity.getTicketUuid())
                .isDeleted(productEntity.getIsDeleted())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }
}
