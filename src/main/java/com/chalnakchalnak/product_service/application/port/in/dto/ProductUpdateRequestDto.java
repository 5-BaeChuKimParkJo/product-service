package com.chalnakchalnak.product_service.application.port.in.dto;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductUpdateRequestDto {

    private String productUuid;
    private String title;
    private String categoryId;
    private String description;
    private ProductCondition productCondition;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private Boolean isHide;
    private Status status;
    private String thumbnailUrl;
    private Long price;
    private String ticketUuid;
    private List<String> tagList;

    @Builder
    public ProductUpdateRequestDto(String productUuid,
                                   String title,
                                   String categoryId,
                                   String description,
                                   ProductCondition productCondition,
                                   Boolean isDirectDeal,
                                   String directDealLocation,
                                   Boolean isHide,
                                   Status status,
                                   String thumbnailUrl,
                                   Long price,
                                   String ticketUuid,
                                   List<String> tagList) {
        this.productUuid = productUuid;
        this.title = title;
        this.categoryId = categoryId;
        this.description = description;
        this.productCondition = productCondition;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.isHide = isHide;
        this.status = status;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.ticketUuid = ticketUuid;
        this.tagList = tagList;
    }
}
