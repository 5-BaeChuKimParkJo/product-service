package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
