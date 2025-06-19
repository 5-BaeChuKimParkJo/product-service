package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUuidListRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;

import java.util.List;

public interface ProductUseCase {

    ProductResponseDto getProduct(String productUuid);

    List<ProductResponseDto> getProductList(ProductUuidListRequestDto productUuidListRequestDto);

    List<ProductResponseDto> getAllProductList();

    String createProduct(ProductCreateRequestDto productRequestDto);

    void updateProduct(ProductUpdateRequestDto productUpdateRequestDto);

    void deleteProduct(String productUuid);
}
