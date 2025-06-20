package com.chalnakchalnak.product_service.util;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OutboxUtil {

    private final OutboxRepositoryPort outboxRepositoryPort;
    private final ObjectMapper objectMapper;

    /**
     * 아웃박스 저장
     * */
    public <T> void createOutbox(T domainObject, String aggregateType,
                                  String aggregateId,
                                  String eventType,
                                  String op) throws JsonProcessingException {

        String json = objectMapper.writeValueAsString(domainObject);

        OutboxEntity outboxEntity = OutboxEntity.builder()
                .aggregateType(aggregateType)
                .aggregateId(aggregateId)
                .eventType(eventType)
                .op(op)
                .payload(json)
                .build();

        outboxRepositoryPort.saveEvent(outboxEntity);
    }
}
