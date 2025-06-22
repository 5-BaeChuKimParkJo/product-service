package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductTagListEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.ProductTagListEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListSaveDto;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductTagListRepository implements ProductTagListRepositoryPort {

    private final ProductTagListJpaRepository productTagJpaRepository;
    private final ProductTagListEntityMapper productTagListEntityMapper;

    @Override
    public List<ProductTagListEntity> getProductTagListByProductUuid(String productUuid) {
        return productTagJpaRepository.findProductTagListByProductUuid(productUuid);
    }

    @Override
    public void createProductTagList(ProductTagListSaveDto productTagCreateSaveDto) {
        productTagJpaRepository.save(productTagListEntityMapper.toEntity(productTagCreateSaveDto));
    }

    @Override
    public void deleteProductTagList(ProductTagListEntity productTagListEntity) {
        productTagJpaRepository.delete(productTagListEntity);
    }

    @Override
    public void deleteAllTagIdByProductUuid(String productUuid) {
        productTagJpaRepository.deleteByProductUuid(productUuid);
    }
}
