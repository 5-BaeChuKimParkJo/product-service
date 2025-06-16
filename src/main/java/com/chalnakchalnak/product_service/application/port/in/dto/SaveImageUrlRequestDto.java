package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveImageUrlRequestDto {

    private String imageKey;
    private String productUuid;
    private int idx;

    @Builder
    public SaveImageUrlRequestDto(String imageKey, String productUuid, int idx) {
        this.imageKey = imageKey;
        this.productUuid = productUuid;
        this.idx = idx;
    }

}
