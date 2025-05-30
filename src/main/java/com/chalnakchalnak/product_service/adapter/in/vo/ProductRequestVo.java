package com.chalnakchalnak.product_service.adapter.in.vo;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductRequestVo {

    private List<String> productImageUrList;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private String title;
    private ProductCondition productCondition;
    private String categoryId;
    private String productDescription;
    private Long price;
    private String ticketUuid;
}