package com.chalnakchalnak.product_service.adapter.in.vo;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import lombok.Getter;

@Getter
public class ProductUpdateRequestVo {

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
}
