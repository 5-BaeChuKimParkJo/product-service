package com.chalnakchalnak.product_service.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProductDomain {

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
    private String thumbnailKey;
    private Long viewCount;
    private Long price;
    private String ticketUuid;
    private List<Long> tagIdList;
    private List<String> productImageKeyList;
    private Boolean isDeleted;
    private LocalDateTime createdAt;

    @Builder
    public ProductDomain(String productUuid,
                         String saleMemberUuid,
                         String title,
                         String categoryId,
                         String description,
                         ProductCondition productCondition,
                         Boolean isDirectDeal,
                         String directDealLocation,
                         Boolean isHide,
                         Status status,
                         String thumbnailKey,
                         Long viewCount,
                         Long price,
                         String ticketUuid,
                         List<String> productImageKeyList,
                         List<Long> tagIdList,
                         Boolean isDeleted,
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
        this.thumbnailKey = thumbnailKey;
        this.viewCount = viewCount;
        this.price = price;
        this.ticketUuid = ticketUuid;
        this.productImageKeyList = productImageKeyList;
        this.tagIdList = tagIdList;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
    }

    public void setThumbnailKey(int index) {
        if (productImageKeyList.size() < index) {
            throw new BaseException(BaseResponseStatus.INTERNAL_SERVER_ERROR);
        }
        this.thumbnailKey = productImageKeyList.get(index);
    }

    public void plusViewCount() {
        this.viewCount++;
    }

    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    public void setTicket(String ticketUuid) {
        this.ticketUuid = ticketUuid;
    }

    public void cancelTicket() {
        this.ticketUuid = null;
    }

    public void setDirectDeal(String directDealLocation) {
        this.isDirectDeal = true;
        this.directDealLocation = directDealLocation;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void deleteProduct() {
        this.isDeleted = true;
    }
}
