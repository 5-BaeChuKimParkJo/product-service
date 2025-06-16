package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductCreateRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductUpdateRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductUuidListRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUuidListRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductVoMapper {


    public ProductResponseVo toProductResponseVo(ProductResponseDto productResponseDto) {
        return ProductResponseVo.builder()
                .productUuid(productResponseDto.getProductUuid())
                .saleMemberUuid(productResponseDto.getSaleMemberUuid())
                .title(productResponseDto.getTitle())
                .categoryId(productResponseDto.getCategoryId())
                .description(productResponseDto.getDescription())
                .productCondition(productResponseDto.getProductCondition())
                .isDirectDeal(productResponseDto.getIsDirectDeal())
                .directDealLocation(productResponseDto.getDirectDealLocation())
                .isHide(productResponseDto.getIsHide())
                .status(productResponseDto.getStatus())
                .thumbnailKey(productResponseDto.getThumbnailKey())
                .viewCount(productResponseDto.getViewCount())
                .price(productResponseDto.getPrice())
                .ticketUuid(productResponseDto.getTicketUuid())
                .createdAt(productResponseDto.getCreatedAt())
                .build();
    }

    public ProductUuidListRequestDto toProductUuidListRequestDto(ProductUuidListRequestVo productUuidListRequestVo) {
        return ProductUuidListRequestDto.builder()
                .productUuidList(productUuidListRequestVo.getProductUuidList())
                .build();
    }

    public ProductCreateRequestDto toProductCreateRequestDto(ProductCreateRequestVo productRequestVo, String memberUuid) {
        return ProductCreateRequestDto.builder()
                .productUuid(UUID.randomUUID().toString())
                .saleMemberUuid(memberUuid)
                .productImageKeyList(productRequestVo.getProductImageKeyList())
                .isDirectDeal(productRequestVo.getIsDirectDeal())
                .directDealLocation(productRequestVo.getDirectDealLocation())
                .title(productRequestVo.getTitle())
                .productCondition(productRequestVo.getProductCondition())
                .categoryId(productRequestVo.getCategoryId())
                .description(productRequestVo.getDescription())
                .price(productRequestVo.getPrice())
                .ticketUuid(productRequestVo.getTicketUuid())
                .tagList(productRequestVo.getTagList())
                .build();
    }

    public ProductUpdateRequestDto toProductUpdateRequestDto(ProductUpdateRequestVo productUpdateRequestVo) {
        return ProductUpdateRequestDto.builder()
                .productUuid(productUpdateRequestVo.getProductUuid())
                .title(productUpdateRequestVo.getTitle())
                .categoryId(productUpdateRequestVo.getCategoryId())
                .description(productUpdateRequestVo.getDescription())
                .productCondition(productUpdateRequestVo.getProductCondition())
                .isDirectDeal(productUpdateRequestVo.getIsDirectDeal())
                .directDealLocation(productUpdateRequestVo.getDirectDealLocation())
                .isHide(productUpdateRequestVo.getIsHide())
                .status(productUpdateRequestVo.getStatus())
                .thumbnailKey(productUpdateRequestVo.getThumbnailKey())
                .price(productUpdateRequestVo.getPrice())
                .ticketUuid(productUpdateRequestVo.getTicketUuid())
                .tagList(productUpdateRequestVo.getTagList())
                .build();
    }

}
