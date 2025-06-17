package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductTagListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductTagListJpaRepository extends JpaRepository<ProductTagListEntity, Long> {

    @Query("SELECT ptl FROM ProductTagListEntity ptl WHERE ptl.productUuid = :productUuid")
    List<ProductTagListEntity> findProductTagListByProductUuid(@Param("productUuid") String productUuid);
}
