package com.chalnakchalnak.product_service.application.port.in.dto;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DealCompleteSaveDto {

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
    public DealCompleteSaveDto(String saleMemberUuid,
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
}
