package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "outbox")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OutboxEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aggregateType; // ex: "Order"

    private String aggregateId;   // ex: 주문 ID

    private String eventType;     // ex: "OrderCreated"

    private String op;                // c / u / d

    @Lob
    private String payload;       // 직렬화된 JSON 문자열

    @Builder
    public OutboxEntity(Long id,
                        String aggregateType,
                        String aggregateId,
                        String eventType,
                        String op,
                        String payload,
                        Boolean _deleted) {
        this.id = id;
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.op = op;
        this.payload = payload;
    }

}
