package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ImageUrl {

    private Long productImageId;
    private String url;
    private int order;

    @Builder
    public ImageUrl(Long productImageId, String url, int order) {
        this.productImageId = productImageId;
        this.url = url;
        this.order = order;
    }
}
