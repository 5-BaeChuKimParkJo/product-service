package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "product_uuid", unique = true, nullable = false, length = 50)
    private String productUuid;

    @Column(name = "sale_member_uuid", nullable = false, length = 50)
    private String saleMemberUuid;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "category_id", nullable = false)
    private String categoryId;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "product_condition", nullable = false)
    private ProductCondition productCondition;

    @Column(name = "is_direct_deal", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isDirectDeal;

    @Column(name = "direct_deal_location")
    private String directDealLocation;

    @Column(name = "is_hide", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isHide;

    @Column(name = "status")
    private Status status;

    @Lob
    @Column(name = "thumbnail_url", columnDefinition = "LONGTEXT")
    private String thumbnailUrl;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "price")
    private Long price;

    @Column(name = "ticket_uuid")
    private String ticketUuid;

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isDeleted = false;

    @Builder
    public ProductEntity(String productUuid,
                         String saleMemberUuid,
                         String title,
                         String categoryId,
                         String description,
                         ProductCondition productCondition,
                         Boolean isDirectDeal,
                         String directDealLocation,
                         Boolean isHide,
                         Status status,
                         String thumbnailUrl,
                         Long viewCount,
                         Long price,
                         String ticketUuid,
                         Boolean isDeleted) {
        this.productUuid = productUuid;
        this.saleMemberUuid = saleMemberUuid;
        this.title = title;
        this.categoryId = categoryId;
        this.description = description;
        this.productCondition = productCondition;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.isHide = isHide;
        this.status = status;
        this.thumbnailUrl = thumbnailUrl;
        this.viewCount = viewCount;
        this.price = price;
        this.ticketUuid = ticketUuid;
        this.isDeleted = isDeleted;
    }

}
