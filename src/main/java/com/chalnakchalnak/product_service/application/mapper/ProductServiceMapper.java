package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductServiceMapper {

    public ProductDomain toProductDomain(ProductRequestDto productRequestDto) {
        return ProductDomain.builder()
                .productUuid(UUID.randomUUID().toString())
                .productImageUrList(productRequestDto.getProductImageUrList())
                .isDirectDeal(productRequestDto.getIsDirectDeal())
                .directDealLocation(productRequestDto.getDirectDealLocation())
                .title(productRequestDto.getTitle())
                .productCondition(productRequestDto.getProductCondition())
                .categoryId(productRequestDto.getCategoryId())
                .price(productRequestDto.getPrice())
                .ticketUuid(productRequestDto.getTicketUuid())
                .build();
    }

    public ProductSaveDto toProductSaveDto(ProductDomain productDomain) {
        return ProductSaveDto.builder()
                .productUuid(UUID.randomUUID().toString())
                .saleMemberUuid(productDomain.getSaleMemberUuid())
                .title(productDomain.getTitle())
                .categoryId(productDomain.getCategoryId())
                .description(productDomain.getDescription())
                .productCondition(productDomain.getProductCondition())
                .isDirectDeal(productDomain.getIsDirectDeal())
                .thumbnailUrl(productDomain.getThumbnailUrl())
                .price(productDomain.getPrice())
                .ticketId(productDomain.getTicketUuid())
                .build();
    }
}
