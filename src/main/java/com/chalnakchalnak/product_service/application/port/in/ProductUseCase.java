package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;

public interface ProductUseCase {

    ProductResponseDto getProduct(String productUuid);

    void createProduct(ProductCreateRequestDto productRequestDto);

    void updateProduct(ProductUpdateRequestDto productUpdateRequestDto);

    void deleteProduct(String productUuid);
}
