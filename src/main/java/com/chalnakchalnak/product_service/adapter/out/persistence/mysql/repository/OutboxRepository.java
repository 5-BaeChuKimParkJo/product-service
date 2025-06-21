package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.OutboxEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OutboxRepository implements OutboxRepositoryPort {

    private final OutboxJpaRepository outboxJpaRepository;
    private final OutboxEntityMapper outboxEntityMapper;

    @Override
    public List<OutboxEntity> getPendigOutboxList() {
        return outboxJpaRepository.findPendingOutbox();
    }

    @Override
    public OutboxEntity saveEvent(OutboxSaveDto outboxSaveDto) {
        return outboxJpaRepository.save(outboxEntityMapper.toOutboxEntityMapper(outboxSaveDto));
    }

}
