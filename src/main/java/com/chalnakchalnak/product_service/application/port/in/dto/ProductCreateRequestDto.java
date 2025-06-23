package com.chalnakchalnak.product_service.application.port.in.dto;

import com.chalnakchalnak.product_service.adapter.in.vo.Images;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductCreateRequestDto {

    private String productUuid;
    private String saleMemberUuid;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private String title;
    private ProductCondition productCondition;
    private String categoryId;
    private String description;
    private Long price;
    private String ticketUuid;
    private List<Long> tagIdList;
    private List<Images> imageList;

    @Builder
    public ProductCreateRequestDto(String productUuid,
                                   String saleMemberUuid,
                                   Boolean isDirectDeal,
                                   String directDealLocation,
                                   String title,
                                   ProductCondition productCondition,
                                   String categoryId,
                                   String description,
                                   Long price,
                                   String ticketUuid,
                                   List<Long> tagIdList,
                                   List<Images> imageList) {
        this.productUuid = productUuid;
        this.saleMemberUuid = saleMemberUuid;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.title = title;
        this.productCondition = productCondition;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.ticketUuid = ticketUuid;
        this.tagIdList = tagIdList;
        this.imageList = imageList;
    }
}
