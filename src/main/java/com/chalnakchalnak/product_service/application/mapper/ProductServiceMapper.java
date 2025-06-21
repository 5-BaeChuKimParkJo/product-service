package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductServiceMapper {

    public ProductDomain toProductDomain(ProductCreateRequestDto productCreateRequestDto) {
        return ProductDomain.builder()
                .productUuid(productCreateRequestDto.getProductUuid())
                .saleMemberUuid(productCreateRequestDto.getSaleMemberUuid())
                .isDirectDeal(productCreateRequestDto.getIsDirectDeal())
                .directDealLocation(productCreateRequestDto.getDirectDealLocation())
                .title(productCreateRequestDto.getTitle())
                .productCondition(productCreateRequestDto.getProductCondition())
                .categoryId(productCreateRequestDto.getCategoryId())
                .description(productCreateRequestDto.getDescription())
                .price(productCreateRequestDto.getPrice())
                .ticketUuid(productCreateRequestDto.getTicketUuid())
                .tagIdList(productCreateRequestDto.getTagIdList())
                .imageKeyList(productCreateRequestDto.getImageKeyList())
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
                .thumbnailKey(productUpdateRequestDto.getThumbnailKey())
                .price(productUpdateRequestDto.getPrice())
                .ticketUuid(productUpdateRequestDto.getTicketUuid())
                .tagIdList(productUpdateRequestDto.getTagIdList())
                .build();
    }

    public ProductResponseDto from(ProductDomain productDomain) {
        return ProductResponseDto.builder()
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
                .thumbnailKey(productDomain.getThumbnailKey())
                .viewCount(productDomain.getViewCount())
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .imageKeyList(productDomain.getImageKeyList())
                .tagIdList(productDomain.getTagIdList())
                .createdAt(productDomain.getCreatedAt())
                .build();
    }

    public ProductCreateSaveDto toProductSaveDto(ProductDomain productDomain) {
        return ProductCreateSaveDto.builder()
                .productUuid(productDomain.getProductUuid())
                .saleMemberUuid(productDomain.getSaleMemberUuid())
                .title(productDomain.getTitle())
                .categoryId(productDomain.getCategoryId())
                .description(productDomain.getDescription())
                .productCondition(productDomain.getProductCondition())
                .isHide(productDomain.getIsHide())
                .status(productDomain.getStatus())
                .isDirectDeal(productDomain.getIsDirectDeal())
                .directDealLocation(productDomain.getDirectDealLocation())
                .thumbnailKey(productDomain.getThumbnailKey())
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
                .thumbnailKey(productDomain.getThumbnailKey())
                .price(productDomain.getPrice())
                .ticketUuid(productDomain.getTicketUuid())
                .build();
    }

}
