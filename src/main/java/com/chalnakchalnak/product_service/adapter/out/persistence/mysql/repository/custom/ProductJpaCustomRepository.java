package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository.custom;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;

public interface ProductJpaCustomRepository {
    long updateProductDynamic(ProductUpdateSaveDto productUpdateSaveDto);
}
