package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductImageUrlSaveDto {

    private String uploadFileUrl;
    private String productUuid;
    private int idx;

    @Builder
    public ProductImageUrlSaveDto(String uploadFileUrl,
                                  String productUuid,
                                  int idx) {
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.idx = idx;
    }
}
