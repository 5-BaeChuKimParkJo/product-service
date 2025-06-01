package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

//    private String productUuid;
//    private String saleMemberUuid;
//    private String title;
//    private String categoryId;
//    private String description;
//    private ProductCondition productCondition;
//    private Boolean isDirectDeal;
//    private String directDealLocation;
//    private Boolean isHide;
//    private Status status;
//    private String thumbnailUrl;
//    private Long viewCount;
//    private Long price;
//    private String ticketId;
//    private LocalDateTime createdAt;

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
                .thumbnailUrl(productEntity.getThumbnailUrl())
                .viewCount(productEntity.getViewCount())
                .price(productEntity.getPrice())
                .ticketUuid(productEntity.getTicketUuid())
                .createdAt(productEntity.getCreatedAt())
                .build();
    }

    public ProductEntity toEntity(ProductSaveDto productSaveDto) {
        return ProductEntity.builder()
                .productUuid(productSaveDto.getProductUuid())
                .saleMemberUuid(productSaveDto.getSaleMemberUuid())
                .title(productSaveDto.getTitle())
                .categoryId(productSaveDto.getCategoryId())
                .description(productSaveDto.getDescription())
                .productCondition(productSaveDto.getProductCondition())
                .isDirectDeal(productSaveDto.getIsDirectDeal())
                .directDealLocation(productSaveDto.getDirectDealLocation())
                .isHide(false)
                .status(Status.ONGOING)
                .thumbnailUrl(productSaveDto.getThumbnailUrl())
                .viewCount(0L)
                .price(productSaveDto.getPrice())
                .ticketUuid(productSaveDto.getTicketUuid())
                .build();
    }
}
