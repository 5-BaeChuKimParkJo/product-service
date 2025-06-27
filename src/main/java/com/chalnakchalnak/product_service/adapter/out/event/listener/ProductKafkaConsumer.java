package com.chalnakchalnak.product_service.adapter.out.event.listener;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductKafkaConsumer {

//    private final ObjectMapper objectMapper;

//    @KafkaListener(
//            topics = "product-service.outbox",
//            groupId = "product-group-1",
//            containerFactory = "kafkaListenerContainerFactory"
//    )
//    public void consumeProductEvent(List<ConsumerRecord<String, String>> records) {
//        for (ConsumerRecord<String, String> record : records) {
//            String message = record.value();
//            try {
//
//
//            } catch (Exception e) {
//                log.error("❌ Kafka 메시지 파싱 실패", e);
//            }
//        }
//    }
}
