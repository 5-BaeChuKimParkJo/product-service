package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductEntityMapper;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository.custom.ProductJpaCustomRepository;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import com.chalnakchalnak.product_service.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductTagListJpaRepository productTagListJpaRepository;
    private final ProductJpaCustomRepository productJpaCustomRepository;
    private final ProductEntityMapper productEntityMapper;
    private final CacheUtil cacheUtil;


    @Override
    public Long getProductId(String productUuid) {
        return productJpaRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT))
                .getId();
    }

    @Override
    @Cacheable(value = "productDomain", key = "#productUuid")
    public ProductDomain getProduct(String productUuid) {
        ProductEntity productEntity = productJpaRepository.findByProductUuidAndActive(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));

        List<String> imageKeyList = productImageJpaRepository.findByProductUuid(productUuid)
                .stream()
                .sorted(Comparator.comparing(productImageEntity -> productImageEntity.getIdx()))
                .map(productImageEntity -> productImageEntity.getImageKey())
                .toList();

        List<Long> tagIdList = productTagListJpaRepository.findByProductUuid(productUuid)
                .stream()
                .sorted(Comparator.comparing(productTagListEntity -> productTagListEntity.getIdx()))
                .map(productTagListEntity -> productTagListEntity.getTagId())
                .toList();

        return productEntityMapper.from(productEntity, imageKeyList, tagIdList);
    }

    @Override
    public ProductDomain getProductForOutbox(String productUuid) {
        ProductEntity productEntity = productJpaRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));

        List<String> imageKeyList = productImageJpaRepository.findByProductUuid(productUuid)
                .stream()
                .sorted(Comparator.comparing(productImageEntity -> productImageEntity.getIdx()))
                .map(productImageEntity -> productImageEntity.getImageKey())
                .toList();

        List<Long> tagIdList = productTagListJpaRepository.findByProductUuid(productUuid)
                .stream()
                .sorted(Comparator.comparing(productTagListEntity -> productTagListEntity.getIdx()))
                .map(productTagListEntity -> productTagListEntity.getTagId())
                .toList();

        return productEntityMapper.from(productEntity, imageKeyList, tagIdList);
    }


    @Override
    public List<ProductDomain> getAllProduct() {
        return productJpaRepository.findAll()
                .stream()
                .map(productEntity -> productEntityMapper.from(productEntity))
                .toList();
    }

    @Override
    public List<ProductDomain> getHideProductList(String memberUuid) {
        return productJpaRepository.findBySaleMemberUuidAndIsHideTrue(memberUuid)
                .stream()
                .map(productEntity -> productEntityMapper.from(productEntity))
                .toList();
    }

    @Override
    public ProductEntity createProduct(ProductCreateSaveDto productSaveDto) {
        return productJpaRepository.save(productEntityMapper.toEntity(productSaveDto));
    }

    @Override
    public void updateProduct(ProductUpdateSaveDto productUpdateSaveDto) {
        productJpaCustomRepository.updateProductDynamic(productUpdateSaveDto);

        cacheUtil.evictCache("productDomain", productUpdateSaveDto.getProductUuid());
    }

    @Override
    public Boolean exists(String productUuid) {
        return productJpaRepository.findByProductUuidAndIsDeletedFalse(productUuid).isPresent();
    }

    @Override
    public void softDeleteProduct(String productUuid) {
        productJpaRepository.softDelete(productUuid);

        cacheUtil.evictCache("productDomain", productUuid);
    }
}
