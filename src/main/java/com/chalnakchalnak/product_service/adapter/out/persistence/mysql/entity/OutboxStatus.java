package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OutboxStatus {

    PENDING("대기 중"),
    COMPLETED("완료"),
    ;

    private final String label;
}
