package com.chalnakchalnak.product_service.application.port.in.dto.event;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Op;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OutboxSaveDto {

    private String aggregateType; // ex: "Order"
    private Long aggregateId;   // ex: 주문 ID
    private String eventType;     // ex: "OrderCreated"
    private String op;                // c / u / d
    private String payload;       // 직렬화된 JSON 문자열
    private OutboxStatus status;

    @Builder
    public OutboxSaveDto(String aggregateType, Long aggregateId, String eventType, String op, String payload, OutboxStatus status) {
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.op = op;
        this.payload = payload;
        this.status = status;
    }
}
