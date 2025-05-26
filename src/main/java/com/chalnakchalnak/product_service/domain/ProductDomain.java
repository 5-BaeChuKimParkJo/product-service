package com.chalnakchalnak.product_service.domain;

import lombok.Builder;

public class ProductDomain {

    private String productUuid;
    private String saleMemberUuid;
    private String title;
    private String categoryId;
    private String productDescription;
    private String productCondition;
    private Boolean isDirectDeal;
    private Boolean isHide;
    private Status status;
    private String thumbnailUrl;

    @Builder
    public ProductDomain(String productUuid,
                         String saleMemberUuid,
                         String title,
                         String categoryId,
                         String productDescription,
                         String productCondition,
                         Boolean isDirectDeal,
                         Boolean isHide,
                         Status status,
                         String thumbnailUrl) {
        this.productUuid = productUuid;
        this.saleMemberUuid = saleMemberUuid;
        this.title = title;
        this.categoryId = categoryId;
        this.productDescription = productDescription;
        this.productCondition = productCondition;
        this.isDirectDeal = isDirectDeal;
        this.isHide = isHide;
        this.status = status;
        this.thumbnailUrl = thumbnailUrl;
    }

}
