package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductServiceMapper {

    public ProductDomain toProductDomain(ProductCreateRequestDto productRequestDto) {
        return ProductDomain.builder()
                .productUuid(UUID.randomUUID().toString())
                .saleMemberUuid(productRequestDto.getSaleMemberUuid())
                .productImageUrList(productRequestDto.getProductImageUrList())
                .isDirectDeal(productRequestDto.getIsDirectDeal())
                .directDealLocation(productRequestDto.getDirectDealLocation())
                .title(productRequestDto.getTitle())
                .productCondition(productRequestDto.getProductCondition())
                .categoryId(productRequestDto.getCategoryId())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .ticketUuid(productRequestDto.getTicketUuid())
                .build();
    }

    public ProductDomain toProductDomain(ProductUpdateRequestDto productUpdateRequestDto) {
        return ProductDomain.builder()
                .productUuid(productUpdateRequestDto.getProductUuid())
                .title(productUpdateRequestDto.getTitle())
                .categoryId(productUpdateRequestDto.getCategoryId())
                .description(productUpdateRequestDto.getDescription())
                .productCondition(productUpdateRequestDto.getProductCondition())
                .isDirectDeal(productUpdateRequestDto.getIsDirectDeal())
                .directDealLocation(productUpdateRequestDto.getDirectDealLocation())
                .isHide(productUpdateRequestDto.getIsHide())
                .status(productUpdateRequestDto.getStatus())
                .thumbnailUrl(productUpdateRequestDto.getThumbnailUrl())
                .price(productUpdateRequestDto.getPrice())
                .ticketUuid(productUpdateRequestDto.getTicketUuid())
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
                .directDealLocation(productDomain.getDirectDealLocation())
                .thumbnailUrl(productDomain.getThumbnailUrl())
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .build();
    }

    public ProductUpdateRequestDto toUpdateRequestDto(ProductDomain productDomain) {
        return ProductUpdateRequestDto.builder()
                .productUuid(productDomain.getProductUuid())
                .saleMemberUuid(productDomain.getSaleMemberUuid())
                .title(productDomain.getTitle())
                .categoryId(productDomain.getCategoryId())
                .description(productDomain.getDescription())
                .productCondition(productDomain.getProductCondition())
                .isDirectDeal(productDomain.getIsDirectDeal())
                .directDealLocation(productDomain.getDirectDealLocation())
                .isHide(productDomain.getIsHide())
                .status(productDomain.getStatus())
                .thumbnailUrl(productDomain.getThumbnailUrl())
                .viewCount(productDomain.getViewCount())
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .build();
    }
}
