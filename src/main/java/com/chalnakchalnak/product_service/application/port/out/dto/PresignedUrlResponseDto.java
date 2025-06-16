package com.chalnakchalnak.product_service.application.port.out.dto;

import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class PresignedUrlResponseDto {

    private String url;
    private Map<String, String> fields;

    @Builder
    public PresignedUrlResponseDto(String url, Map<String, String> fields) {
        this.url = url;
        this.fields = fields;
    }
}
