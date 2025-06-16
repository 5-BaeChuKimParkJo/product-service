package com.chalnakchalnak.product_service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageDomain {

    private String imageKey;
    private String productUuid;
    private int idx;

    @Builder
    public ProductImageDomain(String imageKey,
                              String productUuid,
                              int idx) {
        this.imageKey = imageKey;
        this.productUuid = productUuid;
        this.idx = idx;
    }

    public void setIndex(int index) {
        this.idx = idx;
    }
}
