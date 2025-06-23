package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

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
public class DealCompleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "sale_member_uuid")
    private String saleMemberUuid;

    @Column(name = "sale_member_nickname")
    private String saleMemberNickname;

    @Column(name = "buy_member_uuid")
    private String buyMemberUuid;

    @Column(name = "buy_member_nickname")
    private String buyMemberNickname;

    @Column(name = "product_uuid")
    private String productUuid;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "thumbnail_key", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "is_direct_deal")
    private Boolean isDirectDeal;

    @Column(name = "direct_deal_location")
    private String directDealLocation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "price")
    private Long price;

    @Column(name = "deal_start_at")
    private LocalDateTime dealStartAt;

    @Column(name = "deal_complete_at")
    private LocalDateTime dealCompleteAt;

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
                              Status status,
                              Long price,
                              LocalDateTime dealStartAt,
                              LocalDateTime dealCompleteAt) {
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
        this.status = status;
        this.price = price;
        this.dealStartAt = dealStartAt;
        this.dealCompleteAt = dealCompleteAt;
    }

}
