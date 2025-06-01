package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;

public interface ProductRepositoryPort {

    ProductResponseDto getProduct(String productUuid);

    void createProduct(ProductSaveDto productSaveDto);

    void updateProduct(ProductUpdateRequestDto productUpdateDto);

    void deleteProduct(String productUuid);
}
