package com.chalnakchalnak.product_service.application.port.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PresignedUrlResponseDto {

    private String presignedUrl;
    private String uploadFileUrl;

    @Builder
    public PresignedUrlResponseDto(String presignedUrl, String uploadFileUrl) {
        this.presignedUrl = presignedUrl;
        this.uploadFileUrl = uploadFileUrl;
    }
}
