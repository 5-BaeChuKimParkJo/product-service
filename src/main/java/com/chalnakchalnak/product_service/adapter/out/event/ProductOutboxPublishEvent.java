package com.chalnakchalnak.product_service.adapter.out.event;

import lombok.Getter;

@Getter
public class ProductOutboxPublishEvent {

    private String topic;

    public ProductOutboxPublishEvent(String topic) {
        this.topic = topic;
    }
}
