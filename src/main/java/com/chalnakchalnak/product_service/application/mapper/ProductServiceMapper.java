package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.adapter.in.feign.dto.BuyCouponRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductServiceMapper {

    public ProductDomain toProductDomain(ProductCreateRequestDto productCreateRequestDto) {
        return ProductDomain.builder()
                .productUuid(UUID.randomUUID().toString())
                .saleMemberUuid(productCreateRequestDto.getSaleMemberUuid())
                .productImageUrList(productCreateRequestDto.getProductImageUrList())
                .isDirectDeal(productCreateRequestDto.getIsDirectDeal())
                .directDealLocation(productCreateRequestDto.getDirectDealLocation())
                .title(productCreateRequestDto.getTitle())
                .productCondition(productCreateRequestDto.getProductCondition())
                .categoryId(productCreateRequestDto.getCategoryId())
                .description(productCreateRequestDto.getDescription())
                .price(productCreateRequestDto.getPrice())
                .ticketUuid(productCreateRequestDto.getTicketUuid())
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

    public ProductDomain toProductDomain(BuyCouponRequestDto buyCouponRequestDto) {
        return ProductDomain.builder()
                .productUuid(buyCouponRequestDto.getProductUuid())
                .saleMemberUuid(buyCouponRequestDto.getMemberUuid())
                .ticketUuid(buyCouponRequestDto.getCouponUuid())
                .build();
    }

    public ProductCreateSaveDto toProductSaveDto(ProductDomain productDomain) {
        return ProductCreateSaveDto.builder()
                .productUuid(UUID.randomUUID().toString())
                .saleMemberUuid(productDomain.getSaleMemberUuid())
                .title(productDomain.getTitle())
                .categoryId(productDomain.getCategoryId())
                .description(productDomain.getDescription())
                .productCondition(productDomain.getProductCondition())
                .isDirectDeal(productDomain.getIsDirectDeal())
                .directDealLocation(productDomain.getDirectDealLocation())
                .thumbnailUrl(productDomain.getThumbnailUrl())
                .viewCount(0L)
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .build();
    }

    public ProductUpdateSaveDto toUpdateSaveDto(ProductDomain productDomain) {
        return ProductUpdateSaveDto.builder()
                .productUuid(productDomain.getProductUuid())
                .title(productDomain.getTitle())
                .categoryId(productDomain.getCategoryId())
                .description(productDomain.getDescription())
                .productCondition(productDomain.getProductCondition())
                .isDirectDeal(productDomain.getIsDirectDeal())
                .directDealLocation(productDomain.getDirectDealLocation())
                .isHide(productDomain.getIsHide())
                .status(productDomain.getStatus())
                .thumbnailUrl(productDomain.getThumbnailUrl())
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .build();
    }
}
