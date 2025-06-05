package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveImageUrlRequestDto {

    private String presignedUrl;
    private String uploadFileUrl;
    private String productUuid;
    private int index;

    @Builder
    public SaveImageUrlRequestDto(String presignedUrl, String uploadFileUrl, String productUuid, int index) {
        this.presignedUrl = presignedUrl;
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.index = index;
    }

}
