package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.OutboxEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OutboxRepository implements OutboxRepositoryPort {

    private final OutboxJpaRepository outboxJpaRepository;
    private final OutboxEntityMapper outboxEntityMapper;

    @Override
    public OutboxEntity findOutbox(Long outboxId) {
        return outboxJpaRepository.findById(outboxId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXISTS_OUTBOX));
    }

    @Override
    public List<OutboxEntity> findAll() {
        return outboxJpaRepository.findAll();
    }

    @Override
    public OutboxEntity saveEvent(OutboxSaveDto outboxSaveDto) {
        return outboxJpaRepository.save(outboxEntityMapper.toOutboxEntityMapper(outboxSaveDto));
    }

    @Override
    public void deleteOutbox(OutboxEntity outboxEntity) {
        outboxJpaRepository.delete(outboxEntity);
    }

}
