package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import org.springframework.stereotype.Component;

@Component
public class OutboxEntityMapper {

    public OutboxEntity toOutboxEntityMapper(OutboxSaveDto outboxSaveDto) {
        return OutboxEntity.builder()
                .aggregateType(outboxSaveDto.getAggregateType())
                .aggregateId(outboxSaveDto.getAggregateId())
                .eventType(outboxSaveDto.getEventType())
                .op(outboxSaveDto.getOp())
                .payload(outboxSaveDto.getPayload())
                .build();
    }
}
