package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductCreateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.domain.ProductDomain;

import java.util.List;

public interface ProductRepositoryPort {

    Long getProductId(String productUuid);

    ProductDomain getProduct(String productUuid);

    ProductDomain getProductForOutbox(String productUuid);

    List<ProductDomain> getAllProduct();

    List<ProductDomain> getHideProductList(String memberUuid);

    ProductEntity createProduct(ProductCreateSaveDto productSaveDto);

    void updateProduct(ProductUpdateSaveDto productUpdateSaveDto);

    Boolean exists(String productUuid);

    void softDeleteProduct(String productUuid);
}
