package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;

import java.util.Optional;

public interface ProductImageRepositoryPort {

    Optional<ProductImageEntity> getImageUrl(String productUuid, int idx);

    void uploadImageUrl(ProductImageUrlSaveDto productImageUrlSaveDto);

    void deleteImageUrl(String productUuid, int idx);

    void deleteAllImageUrl(String productUuid);
}
