package com.chalnakchalnak.product_service.application.port.in.dto.event;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OutboxSaveDto {

    private String aggregateType;
    private String aggregateId;
    private String eventType;
    private String payload;

    @Builder
    public OutboxSaveDto(String aggregateType,
                         String aggregateId,
                         String eventType,
                         String payload) {
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
    }
}