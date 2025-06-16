package com.chalnakchalnak.product_service.application.port.in.dto;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductCreateRequestDto {

    private String productUuid;
    private String saleMemberUuid;
    private List<String> productImageKeyList;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private String title;
    private ProductCondition productCondition;
    private String categoryId;
    private String description;
    private Long price;
    private String ticketUuid;
    private List<String> tagList;

    @Builder
    public ProductCreateRequestDto(String productUuid,
                                   String saleMemberUuid,
                                   List<String> productImageKeyList,
                                   Boolean isDirectDeal,
                                   String directDealLocation,
                                   String title,
                                   ProductCondition productCondition,
                                   String categoryId,
                                   String description,
                                   Long price,
                                   String ticketUuid,
                                   List<String> tagList) {
        this.productUuid = productUuid;
        this.saleMemberUuid = saleMemberUuid;
        this.productImageKeyList = productImageKeyList;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.title = title;
        this.productCondition = productCondition;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.ticketUuid = ticketUuid;
        this.tagList = tagList;
    }
}
