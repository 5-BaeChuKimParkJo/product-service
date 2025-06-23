package com.chalnakchalnak.product_service.adapter.out.event.listener;

import com.chalnakchalnak.product_service.adapter.out.event.ProductCreateEvent;
import com.chalnakchalnak.product_service.adapter.out.event.ProductDeleteEvent;
import com.chalnakchalnak.product_service.adapter.out.event.ProductOutboxPublishEvent;
import com.chalnakchalnak.product_service.adapter.out.event.ProductUpdateEvent;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.AggregateType;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.EventType;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Op;
import com.chalnakchalnak.product_service.application.mapper.OutboxServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;
import com.chalnakchalnak.product_service.application.port.out.OutboxRepositoryPort;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductEventListener {

    private final OutboxRepositoryPort outboxRepositoryPort;
    private final OutboxServiceMapper outboxServiceMapper;
    private final KafkaTemplate kafkaTemplate;
    private final ApplicationEventPublisher eventPublisher;

    private final String TOPIC1 = "product-service.outbox";

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleProductCreateEvent(ProductCreateEvent productCreateEvent) {

        // 아웃박스 저장
        try {

            ProductDomain productDomain = productCreateEvent.getProductDomain();

            OutboxSaveDto outboxSaveDto = outboxServiceMapper.toOutboxSaveDto(productDomain, AggregateType.PRODUCT, productDomain.getId(), EventType.PRODUCT_CREATE, Op.C, TOPIC1);

            outboxRepositoryPort.saveEvent(outboxSaveDto);

            eventPublisher.publishEvent(new ProductOutboxPublishEvent());

        } catch (JsonProcessingException e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE_OUTBOX);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleProductUpdateEvent(ProductUpdateEvent productUpdateEvent) {

        // 아웃박스 저장
        try {
            outboxRepositoryPort.saveEvent(outboxServiceMapper.toOutboxSaveDto(productUpdateEvent.getProductDomain(),
                    AggregateType.PRODUCT,
                    productUpdateEvent.getProductDomain().getId(),
                    EventType.PRODUCT_UPDATE,
                    Op.U,
                    TOPIC1));

            eventPublisher.publishEvent(new ProductOutboxPublishEvent());

        } catch (JsonProcessingException e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE_OUTBOX);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleProductDeleteEvent(ProductDeleteEvent productDeleteEvent) {

        // 아웃박스 저장
        try {
            outboxRepositoryPort.saveEvent(outboxServiceMapper.toOutboxSaveDto(null,
                    AggregateType.PRODUCT,
                    productDeleteEvent.getProductId(),
                    EventType.PRODUCT_DELETE,
                    Op.D,
                    TOPIC1));

            eventPublisher.publishEvent(new ProductOutboxPublishEvent());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleProductEvent(ProductOutboxPublishEvent event) {

        log.info("AFTER_COMMIT!!!!");
        log.info("event {}", event);
//        List<OutboxEntity> outboxList = outboxRepositoryPort.findAll();
//        for (OutboxEntity outboxEntity : outboxList) {
//            kafkaTemplate.send(outboxEntity.getTopic(), outboxEntity);
//            outboxRepositoryPort.deleteOutbox(outboxEntity);
//        }
    }

}
