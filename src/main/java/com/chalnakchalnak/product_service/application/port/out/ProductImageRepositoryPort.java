package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;

import java.util.List;

public interface ProductImageRepositoryPort {

    void uploadImageUrl(ProductImageUrlSaveDto productImageUrlSaveDto);

    void deleteImageUrl(String productUuid, int idx);

    void deleteAllImageUrl(String productUuid);
}
