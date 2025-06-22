package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByProductUuid(String productUuid);

    @Query("SELECT p FROM ProductEntity p WHERE p.productUuid = :productUuid AND p.isDeleted != true AND p.isHide != true")
    Optional<ProductEntity> findByProductUuidAndActive(@Param("productUuid") String productUuid);

    Optional<ProductEntity> findByProductUuidAndIsDeletedFalse(String productUuid);

    List<ProductEntity> findAllByIsDeletedFalse();

    List<ProductEntity> findBySaleMemberUuidAndIsHideTrue(String saleMemberUuid);

    @Modifying
    @Query("UPDATE ProductEntity p SET p.isDeleted = true WHERE p.productUuid = :productUuid")
    void softDelete(@Param("productUuid") String productUuid);
}
