package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListCreateRequestDto;

public interface ProductTagListUseCase {

    void crateProductTagList(ProductTagListCreateRequestDto productTagListCreateRequestDto);

    void deleteProductTagListByProductUuid(String productUuid);
}
