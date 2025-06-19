package com.chalnakchalnak.product_service.adapter.in.vo;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ProductResponseVo {

    private String productUuid;
    private String saleMemberUuid;
    private String title;
    private String categoryId;
    private String description;
    private ProductCondition productCondition;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private Boolean isHide;
    private Status status;
    private String thumbnailUrl;
    private Long viewCount;
    private Long price;
    private String ticketUuid;
    private List<String> imageUrlList;
    private List<Long> tagIdList;
    private LocalDateTime createdAt;

    @Builder
    public ProductResponseVo(String productUuid,
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
                             List<String> imageUrlList,
                             List<Long> tagIdList,
                             LocalDateTime createdAt) {
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
        this.imageUrlList = imageUrlList;
        this.tagIdList = tagIdList;
        this.createdAt = createdAt;
    }
}
