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

@Repository
@RequiredArgsConstructor
public class ProductImageRepository implements ProductImageRepositoryPort {

    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductImageEntityMapper productImageEntityMapper;

    @Override
    public void uploadImageUrl(ProductImageUrlSaveDto productImageUrlSaveDto) {
        productImageJpaRepository.save(productImageEntityMapper.toEntity(productImageUrlSaveDto));
    }

    @Override
    @Transactional
    public void deleteImageUrl(String productUuid, int idx) {
        ProductImageEntity productImageEntity = productImageJpaRepository.findByProductUuidAndIdx(productUuid, idx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));
        productImageJpaRepository.delete(productImageEntity);
    }

    @Override
    @Transactional
    public void deleteAllImageUrl(String productUuid) {
        List<ProductImageEntity> productImageEntityList = productImageJpaRepository.findByProductUuid(productUuid);
        productImageJpaRepository.deleteAll(productImageEntityList);
    }
}
