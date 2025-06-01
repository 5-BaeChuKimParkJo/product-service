package com.chalnakchalnak.product_service.domain;

import java.util.List;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ProductDomain {

    private Long id;
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

    private List<String> productImageUrList;

    @Builder
    public ProductDomain(Long id,
                         String productUuid,
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
                         List<String> productImageUrList) {
        this.id = id;
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
        this.productImageUrList = productImageUrList;
    }

    public void setThumbnailUrl(int index) {
        if (productImageUrList.size() < index) {
            throw new BaseException(BaseResponseStatus.INTERNAL_SERVER_ERROR);
        }
        this.thumbnailUrl = productImageUrList.get(index);
    }

    public void plusViewCount() {
        this.viewCount++;
    }

    public void setToggleHide() {
        if(this.isHide) isHide = false;
        else isHide = true;
    }

    public void setTicket(String ticketUuid) {
        this.ticketUuid = ticketUuid;
    }

    public void cancelTicket() {
        this.ticketUuid = null;
    }

    public void cancelDirectDeal() {
        this.isDirectDeal = false;
        this.directDealLocation = null;
    }

    public void setDirectDeal(String directDealLocation) {
        this.isDirectDeal = true;
        this.directDealLocation = directDealLocation;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
