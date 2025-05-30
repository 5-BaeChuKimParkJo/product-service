package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;

import java.util.List;

public interface ProductRepositoryPort {

    ProductResponseDto getProductPreview(String productUuid);
    List<ProductResponseDto> getProductPreviewList();
    void createProduct(ProductSaveDto productSaveDto);
}
