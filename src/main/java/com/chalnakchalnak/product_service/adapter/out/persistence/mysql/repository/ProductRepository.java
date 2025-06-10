package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductEntityMapper;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository.custom.ProductJpaCustomRepository;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaCustomRepository productJpaCustomRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public ProductDomain getProduct(String productUuid) {
        ProductEntity productEntity = productJpaRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));
        return productEntityMapper.from(productEntity);
    }

    @Override
    public void createProduct(ProductCreateSaveDto productSaveDto) {
        productJpaRepository.save(productEntityMapper.toEntity(productSaveDto));
    }

    @Override
    public void updateProduct(ProductUpdateSaveDto productUpdateSaveDto) {
        productJpaCustomRepository.updateProductDynamic(productUpdateSaveDto);
    }

    @Override
    public void softDeleteProduct(String productUuid) {
        productJpaRepository.softDelete(productUuid);
    }
}
