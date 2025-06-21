package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.AggregateType;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.EventType;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Op;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxStatus;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OutboxServiceMapper {

    private final ObjectMapper objectMapper;

    public <T> OutboxSaveDto toOutboxSaveDto(T domainObject,
                                             AggregateType aggregateType,
                                             Long aggregateId,
                                             EventType eventType,
                                             Op op) throws JsonProcessingException {

        String json = objectMapper.writeValueAsString(domainObject);

        return  OutboxSaveDto.builder()
                .aggregateType(aggregateType.getName())
                .aggregateId(aggregateId)
                .eventType(eventType.getName())
                .op(op.getName())
                .payload(json)
                .status(OutboxStatus.PENDING)
                .build();
    }
}
