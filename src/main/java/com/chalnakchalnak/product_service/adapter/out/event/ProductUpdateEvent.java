package com.chalnakchalnak.product_service.adapter.out.event;

import com.chalnakchalnak.product_service.domain.ProductDomain;

public class ProductUpdateEvent {

    private final ProductDomain productDomain;

    public ProductUpdateEvent(ProductDomain productDomain) {
        this.productDomain = productDomain;
    }

    public ProductDomain getProductDomain() {
        return productDomain;
    }
}
