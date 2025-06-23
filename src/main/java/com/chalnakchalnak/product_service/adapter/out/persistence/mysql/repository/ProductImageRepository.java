package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductImageEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductImageUrlSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductImageRepository implements ProductImageRepositoryPort {

    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductImageEntityMapper productImageEntityMapper;


    @Override
    public int getMaxImageIdx(String productUuid) {
        return productImageJpaRepository.findMaxImageIdx(productUuid);
    }

    @Override
    public Optional<ProductImageEntity> getImageUrl(String productUuid, int order) {
        return  productImageJpaRepository.findByProductUuidAndOrder(productUuid, order);
    }

    @Override
    public void uploadImageKey(ProductImageUrlSaveDto productImageUrlSaveDto) {
        productImageJpaRepository.save(productImageEntityMapper.toEntity(productImageUrlSaveDto));
    }

    @Override
    public void updateImageKey(String productUuid, int order, String key) {
        productImageJpaRepository.updateProductImage(productUuid, order, key);
    }

    @Override
    public void deleteImageKey(String productUuid, int order) {
        ProductImageEntity productImageEntity = productImageJpaRepository.findByProductUuidAndOrder(productUuid, order)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_IMAGE));
        productImageJpaRepository.delete(productImageEntity);
    }

    @Override
    public void deleteAllImageKey(String productUuid) {
        List<ProductImageEntity> productImageEntityList = productImageJpaRepository.findByProductUuid(productUuid);
        productImageJpaRepository.deleteAll(productImageEntityList);
    }
}
