package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PresignedUrlRequestDto {

    private String key;
    private String contentType;

    @Builder
    public PresignedUrlRequestDto(String key, String contentType, String productUuid) {
        this.key = key;
        this.contentType = contentType;
    }
}
