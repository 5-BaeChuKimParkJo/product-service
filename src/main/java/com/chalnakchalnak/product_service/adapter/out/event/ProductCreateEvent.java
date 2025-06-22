package com.chalnakchalnak.product_service.adapter.out.event;

import com.chalnakchalnak.product_service.domain.ProductDomain;

public class ProductCreateEvent {

    private final ProductDomain productDomain;

    public ProductCreateEvent(ProductDomain productDomain) {
        this.productDomain = productDomain;
    }

    public ProductDomain getProductDomain() {
        return productDomain;
    }
}
