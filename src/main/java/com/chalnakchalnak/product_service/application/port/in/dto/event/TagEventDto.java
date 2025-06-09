package com.chalnakchalnak.product_service.application.port.in.dto.event;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TagEventDto {

    private String productUuid;
    private List<String> tagList;

    @Builder
    public TagEventDto(String productUuid, List<String> tagList) {
        this.productUuid = productUuid;
        this.tagList = tagList;
    }
}
