package com.chalnakchalnak.product_service.adapter.out.event;

import com.chalnakchalnak.product_service.domain.ProductDomain;

public class ProductDeleteEvent {

    private final Long productId;

    public ProductDeleteEvent(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
