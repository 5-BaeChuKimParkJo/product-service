package com.chalnakchalnak.product_service.adapter.out.kafka;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaPort {

    void productEvent(String topic, OutboxEntity outboxEntity) throws JsonProcessingException;

    void consumeEvent(String topic);
}
