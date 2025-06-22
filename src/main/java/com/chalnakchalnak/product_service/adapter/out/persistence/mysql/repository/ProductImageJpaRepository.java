package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity, Long> {

    @Query("SELECT COALESCE(MAX(p.idx), 1) FROM ProductImageEntity p WHERE p.productUuid = :productUuid")
    int findMaxImageIdx(@Param("productUuid") String productUuid);

    @Query("SELECT p FROM ProductImageEntity p WHERE p.productUuid = :productUuid AND p.idx = :idx")
    Optional<ProductImageEntity> findByProductUuidAndIdx(@Param("productUuid") String productUuid, @Param("idx") int idx);

    List<ProductImageEntity> findByProductUuid(String productUuid);
}
