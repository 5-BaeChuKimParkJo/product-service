package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageUrlSaveDto {

    private String key;
    private String productUuid;
    private int order;

    @Builder
    public ProductImageUrlSaveDto(String key,
                                  String productUuid,
                                  int order) {
        this.key = key;
        this.productUuid = productUuid;
        this.order = order;
    }
}
