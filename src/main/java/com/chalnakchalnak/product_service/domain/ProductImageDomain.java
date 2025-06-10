package com.chalnakchalnak.product_service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageDomain {

    private String uploadFileUrl;
    private String productUuid;
    private int idx;

    @Builder
    public ProductImageDomain(String uploadFileUrl,
                              String productUuid,
                              int idx) {
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.idx = idx;
    }

    public void setIndex(int index) {
        this.idx = idx;
    }
}
