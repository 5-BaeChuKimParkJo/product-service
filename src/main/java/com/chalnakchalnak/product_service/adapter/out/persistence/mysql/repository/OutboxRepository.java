package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OutboxRepository implements OutboxRepositoryPort {

    private final OutboxJpaRepository outboxJpaRepository;

    @Override
    public void saveEvent(OutboxEntity outboxEntity) {
        outboxJpaRepository.save(outboxEntity);
    }

}
