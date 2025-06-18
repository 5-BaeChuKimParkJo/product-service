package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductTagListSaveDto {

    private String productUuid;
    private Long tagId;
    private int idx;

    @Builder
    public ProductTagListSaveDto(String productUuid, Long tagId, int idx) {
        this.productUuid = productUuid;
        this.tagId = tagId;
        this.idx = idx;
    }
}
