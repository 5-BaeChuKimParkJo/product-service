package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;


import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.DealCompleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealJpaRepository extends JpaRepository<DealCompleteEntity, Long> {
}
