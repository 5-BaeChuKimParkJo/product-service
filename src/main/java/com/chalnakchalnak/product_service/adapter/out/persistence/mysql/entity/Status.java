package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("활성화"), DEALING("거래중"), ENDED("거래종료");

    private final String label;
}
