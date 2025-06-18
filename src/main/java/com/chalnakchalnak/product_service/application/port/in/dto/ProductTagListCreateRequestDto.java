package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductTagListCreateRequestDto {

    private String productUuid;
    private List<Long> tagIdList;

    @Builder
    public ProductTagListCreateRequestDto(String productUuid, List<Long> tagIdList) {
        this.productUuid = productUuid;
        this.tagIdList = tagIdList;
    }
}
