package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductCondition {

    UNOPENED("미개봉새상품"),
    NEW("미사용상품"),
    USED("중고");

    private final String label;
}
