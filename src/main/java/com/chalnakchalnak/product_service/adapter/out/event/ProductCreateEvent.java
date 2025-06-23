package com.chalnakchalnak.product_service.adapter.out.event;

import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.Getter;

@Getter
public class ProductCreateEvent {

    private final ProductDomain productDomain;

    public ProductCreateEvent(ProductDomain productDomain) {
        this.productDomain = productDomain;
    }
}
