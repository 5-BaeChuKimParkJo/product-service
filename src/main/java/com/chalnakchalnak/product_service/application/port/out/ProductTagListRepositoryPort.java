package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductTagListEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListSaveDto;

import java.util.List;

public interface ProductTagListRepositoryPort {

    List<ProductTagListEntity> getProductTagListByProductUuid(String productUuid);

    void createProductTagList(ProductTagListSaveDto productTagSaveDto);

    void deleteProductTagList(ProductTagListEntity productTagListEntity);

    void deleteAllTagIdByProductUuid(String productUuid);
}
