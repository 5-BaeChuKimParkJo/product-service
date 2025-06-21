package com.chalnakchalnak.product_service.adapter.out.kafka;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProductAdapter implements KafkaPort{

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void productEvent(String topic, OutboxEntity outboxEntity) throws JsonProcessingException {
        kafkaTemplate.send(topic, objectMapper.writeValueAsString(outboxEntity));
    }

    @Override
    public void consumeEvent(String topic) {

    }
}
