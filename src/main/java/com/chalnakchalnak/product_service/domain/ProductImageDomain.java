package com.chalnakchalnak.product_service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class ProductImageDomain {

    private String key;
    private String url;
    private String productUuid;
    private int order;

    @Builder
    public ProductImageDomain(String key,
                              String url,
                              String productUuid,
                              int order) {
        this.key = key;
        this.url = url;
        this.productUuid = productUuid;
        this.order = order;
    }
}
