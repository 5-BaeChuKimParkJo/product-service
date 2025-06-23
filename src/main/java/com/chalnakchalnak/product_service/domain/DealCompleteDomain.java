package com.chalnakchalnak.product_service.domain;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DealCompleteDomain {

    private String saleMemberUuid;
    private String saleMemberNickname;
    private String buyMemberUuid;
    private String buyMemberNickname;
    private String productUuid;
    private String title;
    private String description;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private ProductCondition productCondition;
    private Long price;
    private LocalDateTime dealStartAt;
    private LocalDateTime dealCompleteAt;
    private String chatroomUuid;

    @Builder
    public DealCompleteDomain(String saleMemberUuid,
                              String saleMemberNickname,
                              String buyMemberUuid,
                              String buyMemberNickname,
                              String productUuid,
                              String title,
                              String description,
                              Boolean isDirectDeal,
                              String directDealLocation,
                              ProductCondition productCondition,
                              Long price,
                              LocalDateTime dealStartAt,
                              LocalDateTime dealCompleteAt,
                              String chatroomUuid) {
        this.saleMemberUuid = saleMemberUuid;
        this.saleMemberNickname = saleMemberNickname;
        this.buyMemberUuid = buyMemberUuid;
        this.buyMemberNickname = buyMemberNickname;
        this.productUuid = productUuid;
        this.title = title;
        this.description = description;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.productCondition = productCondition;
        this.price = price;
        this.dealStartAt = dealStartAt;
        this.dealCompleteAt = dealCompleteAt;
        this.chatroomUuid = chatroomUuid;
    }

    public void setProductData(ProductDomain productDomain) {
        this.saleMemberUuid = productDomain.getSaleMemberUuid();
        this.title = productDomain.getTitle();
        this.description = productDomain.getDescription();
        this.isDirectDeal = productDomain.getIsDirectDeal();
        this.directDealLocation = productDomain.getDirectDealLocation();
        this.productCondition = productDomain.getProductCondition();
        this.price = productDomain.getPrice();
    }

    public void setDealCompleteAtNow() {
        this.dealCompleteAt = LocalDateTime.now();
    }
}
