package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductRequestDto;

public interface ProductUseCase {

    void createProduct(ProductRequestDto productRequestDto);
}
