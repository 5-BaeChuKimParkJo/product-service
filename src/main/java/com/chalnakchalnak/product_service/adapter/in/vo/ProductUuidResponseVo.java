package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductUuidResponseVo {

    private String productUuid;

    @Builder
    public ProductUuidResponseVo(String productUuid) {
        this.productUuid = productUuid;
    }
}
