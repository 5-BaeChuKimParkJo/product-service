package com.chalnakchalnak.product_service.application.port.in.dto.event;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Op;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OutboxSaveDto {

    private String aggregateType; // ex: "Order"
    private String aggregateId;   // ex: 주문 ID
    private String eventType;     // ex: "OrderCreated"
    private Op op;                // c / u / d
    private String payload;       // 직렬화된 JSON 문자열

    @Builder
    public OutboxSaveDto(String aggregateType, String aggregateId, String eventType, Op op, String payload) {
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.op = op;
        this.payload = payload;
    }
}
