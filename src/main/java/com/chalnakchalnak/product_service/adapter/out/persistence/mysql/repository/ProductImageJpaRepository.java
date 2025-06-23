package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity, Long> {

    @Query("SELECT COALESCE(MAX(p.order), 1) FROM ProductImageEntity p WHERE p.productUuid = :productUuid")
    int findMaxImageIdx(@Param("productUuid") String productUuid);

    @Query("SELECT p FROM ProductImageEntity p WHERE p.productUuid = :productUuid AND p.order = :order")
    Optional<ProductImageEntity> findByProductUuidAndOrder(@Param("productUuid") String productUuid, @Param("order") int order);

    @Query("SELECT p FROM ProductImageEntity p WHERE p.productUuid = :productUuid")
    List<ProductImageEntity> findByProductUuid(@Param("productUuid") String productUuid);

    @Modifying
    @Query("UPDATE ProductImageEntity p SET p.key = :key WHERE p.productUuid = :productUuid AND p.order = :order")
    void updateProductImage(@Param("productUuid") String productUuid,
                            @Param("order") int order,
                            @Param("key") String key);
}
