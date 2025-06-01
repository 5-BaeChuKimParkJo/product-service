package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.ProductResponseDto;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaCustomRepository productJpaCustomRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public ProductResponseDto getProduct(String productUuid) {
        ProductEntity productEntity = productJpaRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));
        return productEntityMapper.toProductResponseDto(productEntity);
    }

    @Override
    public void createProduct(ProductSaveDto productSaveDto) {
        productJpaRepository.save(productEntityMapper.toEntity(productSaveDto));
    }

    @Override
    public void updateProduct(ProductUpdateRequestDto productUpdateDto) {
        productJpaCustomRepository.updateProductDynamic(productUpdateDto);
    }

    @Override
    public void deleteProduct(String productUuid) {
        ProductEntity productEntity = productJpaRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_PRODUCT));
        productJpaRepository.deleteById(productEntity.getId());
    }
}
