package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Images {

    private String key;
    private int order;

    @Builder
    public Images(String key, int order) {
        this.key = key;
        this.order = order;
    }
}
