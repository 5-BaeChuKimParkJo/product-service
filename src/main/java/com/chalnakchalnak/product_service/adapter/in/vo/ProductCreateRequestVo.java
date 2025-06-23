package com.chalnakchalnak.product_service.adapter.in.vo;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductCreateRequestVo {

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
}