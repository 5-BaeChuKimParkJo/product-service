package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class PresignedUrlResponseVo {

    private String url;
    private Map<String, String> fields;

    @Builder
    public PresignedUrlResponseVo(String url, Map<String, String> fields) {
        this.url = url;
        this.fields = fields;
    }
}
