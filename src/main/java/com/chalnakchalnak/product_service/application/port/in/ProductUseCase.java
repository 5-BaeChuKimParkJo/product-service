package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUuidListRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProductUseCase {

    ProductResponseDto getProduct(String productUuid);

    List<ProductResponseDto> getProductList(ProductUuidListRequestDto productUuidListRequestDto);

    List<ProductResponseDto> getAllProductList();

    List<ProductResponseDto> getHideProductList(String memberUuid);

    String createProduct(ProductCreateRequestDto productCreateRequestDto);

    void updateProduct(ProductUpdateRequestDto productUpdateRequestDto);

    void deleteProduct(String productUuid);
}
