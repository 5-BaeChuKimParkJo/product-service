package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductTagListCreateRequestVo {

    private String productUuid;
    private List<Long> tagIdList;
}
