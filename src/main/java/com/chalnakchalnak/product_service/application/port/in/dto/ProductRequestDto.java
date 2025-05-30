package com.chalnakchalnak.product_service.application.port.in.dto;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductRequestDto {

    private List<String> productImageUrList;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private String title;
    private ProductCondition productCondition;
    private String categoryId;
    private String productDescription;
    private Long price;
    private String ticketUuid;

    @Builder
    public ProductRequestDto(List<String> productImageUrList,
                             Boolean isDirectDeal,
                             String directDealLocation,
                             String title,
                             ProductCondition productCondition,
                             String categoryId,
                             String productDescription,
                             Long price,
                             String ticketUuid) {
        this.productImageUrList = productImageUrList;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.title = title;
        this.productCondition = productCondition;
        this.categoryId = categoryId;
        this.productDescription = productDescription;
        this.price = price;
        this.ticketUuid = ticketUuid;
    }

}
