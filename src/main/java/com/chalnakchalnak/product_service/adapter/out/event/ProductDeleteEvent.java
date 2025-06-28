package com.chalnakchalnak.product_service.adapter.out.event;

public class ProductDeleteEvent {

    private final Long productId;

    public ProductDeleteEvent(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
