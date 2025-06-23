package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;

import java.util.Optional;

public interface ProductImageRepositoryPort {

    int getMaxImageIdx(String productUuid);

    Optional<ProductImageEntity> getImageUrl(String productUuid, int order);

    void uploadImageKey(ProductImageUrlSaveDto productImageUrlSaveDto);

    void updateImageKey(String productUuid, int order, String key);

    void deleteImageKey(String productUuid, int order);

    void deleteAllImageKey(String productUuid);
}
