package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;

public interface ProductJpaCustomRepository {
    long updateProductDynamic(ProductUpdateRequestDto productUpdateDto);
}
