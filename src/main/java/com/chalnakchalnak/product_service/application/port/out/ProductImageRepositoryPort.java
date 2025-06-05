package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;

public interface ProductImageRepositoryPort {

    void uploadImageUrl(ProductImageUrlSaveDto productImageUrlSaveDto);
}
