package com.chalnakchalnak.product_service.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ImageResponseDto {

    private Long productImageId;
    private String url;
    private int order;

    @Builder
    public ImageResponseDto(Long productImageId, String url, int order) {
        this.productImageId = productImageId;
        this.url = url;
        this.order = order;
    }
}
