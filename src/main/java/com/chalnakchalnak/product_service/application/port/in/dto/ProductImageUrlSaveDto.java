package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageUrlSaveDto {

    private String imageKey;
    private String productUuid;
    private int idx;

    @Builder
    public ProductImageUrlSaveDto(String imageKey,
                                  String productUuid,
                                  int idx) {
        this.imageKey = imageKey;
        this.productUuid = productUuid;
        this.idx = idx;
    }
}
