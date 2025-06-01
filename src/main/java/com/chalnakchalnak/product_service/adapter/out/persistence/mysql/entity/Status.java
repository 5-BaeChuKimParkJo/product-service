package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    READY("대기"),
    ONGOING("진행중"),
    FINISHED("거래완료");

    private final String label;
}
