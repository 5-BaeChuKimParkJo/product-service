package com.chalnakchalnak.product_service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageDomain {

    private String presignedUrl;
    private String uploadFileUrl;
    private String productUuid;
    private int index;

    @Builder
    public ProductImageDomain(String presignedUrl,
                              String uploadFileUrl,
                              String productUuid,
                              int index) {
        this.presignedUrl = presignedUrl;
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.index = index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
