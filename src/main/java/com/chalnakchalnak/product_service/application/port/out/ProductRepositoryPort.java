package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;

import java.util.List;

public interface ProductRepositoryPort {

    ProductDomain getProduct(String productUuid);

    List<ProductDomain> getAllProduct();

    void createProduct(ProductCreateSaveDto productSaveDto);

    void updateProduct(ProductUpdateSaveDto productUpdateSaveDto);

    void softDeleteProduct(String productUuid);
}
