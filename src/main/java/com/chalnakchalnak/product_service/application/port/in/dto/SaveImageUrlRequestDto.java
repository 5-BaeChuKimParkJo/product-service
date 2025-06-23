package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveImageUrlRequestDto {

    private String key;
    private String productUuid;
    private int order;

    @Builder
    public SaveImageUrlRequestDto(String key, String productUuid, int order) {
        this.key = key;
        this.productUuid = productUuid;
        this.order = order;
    }

}
