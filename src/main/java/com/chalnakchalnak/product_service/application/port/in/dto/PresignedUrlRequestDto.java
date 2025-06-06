package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PresignedUrlRequestDto {

    private String fileName;
    private String contentType;

    @Builder
    public PresignedUrlRequestDto(String fileName, String contentType, String productUuid) {
        this.fileName = fileName;
        this.contentType = contentType;
    }
}
