package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveImageUrlRequestDto {

    private String uploadFileUrl;
    private String productUuid;
    private int idx;

    @Builder
    public SaveImageUrlRequestDto(String uploadFileUrl, String productUuid, int idx) {
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.idx = idx;
    }

}
