package com.chalnakchalnak.product_service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductTagListDomain {

    private String productUuid;
    private Long tagId;
    private int idx;

    @Builder
    public ProductTagListDomain(String productUuid, Long tagId, int idx) {
        this.productUuid = productUuid;
        this.tagId = tagId;
        this.idx = idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
