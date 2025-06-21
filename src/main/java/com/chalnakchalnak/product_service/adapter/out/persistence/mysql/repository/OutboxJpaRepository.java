package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OutboxJpaRepository extends JpaRepository<OutboxEntity, Long> {

    @Query("")
    List<OutboxEntity> findPendingOutbox();
}
