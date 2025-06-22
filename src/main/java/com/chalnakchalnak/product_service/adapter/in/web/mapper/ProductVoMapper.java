package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.*;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUuidListRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductVoMapper {


    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    public ProductUuidResponseVo toProductUuidResponseVo(String productUuid) {
        return ProductUuidResponseVo.builder()
                .productUuid(productUuid)
                .build();
    }

    public ProductResponseVo toProductResponseVo(ProductResponseDto productResponseDto) {

        List<String> imageUrlList = new ArrayList<>();
        if (productResponseDto.getImageKeyList() != null) {
            imageUrlList = productResponseDto.getImageKeyList()
                    .stream()
                    .map(imageKey -> setUrl(imageKey))
                    .toList();
        }

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
                .thumbnailUrl(setUrl(productResponseDto.getThumbnailKey()))
                .viewCount(productResponseDto.getViewCount())
                .price(productResponseDto.getPrice())
                .ticketUuid(productResponseDto.getTicketUuid())
                .imageUrlList(imageUrlList)
                .tagIdList(productResponseDto.getTagIdList())
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
                .imageKeyList(productRequestVo.getImageKeyList())
                .isDirectDeal(productRequestVo.getIsDirectDeal())
                .directDealLocation(productRequestVo.getDirectDealLocation())
                .title(productRequestVo.getTitle())
                .productCondition(productRequestVo.getProductCondition())
                .categoryId(productRequestVo.getCategoryId())
                .description(productRequestVo.getDescription())
                .price(productRequestVo.getPrice())
                .ticketUuid(productRequestVo.getTicketUuid())
                .tagIdList(productRequestVo.getTagIdList())
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
                .tagIdList(productUpdateRequestVo.getTagIdList())
                .imageKeyList(productUpdateRequestVo.getImageKeyList())
                .build();
    }


    private String setUrl(String imageKey) {
        return !"".equals(imageKey) && imageKey != null ?
                "https://" + bucket + ".s3." + region + ".amazonaws.com/" + imageKey : null;
    }

}
