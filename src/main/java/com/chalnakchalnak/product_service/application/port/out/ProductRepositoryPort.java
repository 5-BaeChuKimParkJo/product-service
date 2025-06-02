package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;

public interface ProductRepositoryPort {

    ProductResponseDto getProduct(String productUuid);

    void createProduct(ProductCreateSaveDto productSaveDto);

    void updateProduct(ProductUpdateSaveDto productUpdateSaveDto);

    void deleteProduct(String productUuid);
}
