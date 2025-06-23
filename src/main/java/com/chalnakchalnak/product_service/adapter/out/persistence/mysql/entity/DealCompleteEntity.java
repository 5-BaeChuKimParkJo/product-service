package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "deal_complete")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DealCompleteEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "sale_member_uuid", nullable = false)
    private String saleMemberUuid;

    @Column(name = "sale_member_nickname", nullable = false)
    private String saleMemberNickname;

    @Column(name = "buy_member_uuid", nullable = false)
    private String buyMemberUuid;

    @Column(name = "buy_member_nickname", nullable = false)
    private String buyMemberNickname;

    @Column(name = "product_uuid", nullable = false)
    private String productUuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "is_direct_deal", nullable = false)
    private Boolean isDirectDeal;

    @Column(name = "direct_deal_location")
    private String directDealLocation;

    @Column(name = "product_condition", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "deal_start_at", nullable = false)
    private LocalDateTime dealStartAt;

    @Column(name = "deal_complete_at", nullable = false)
    private LocalDateTime dealCompleteAt;

    @Column(name = "chatroom_uuid", nullable = false)
    private String chatroomUuid;

    @Builder
    public DealCompleteEntity(Long id,
                              String saleMemberUuid,
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
        this.id = id;
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
