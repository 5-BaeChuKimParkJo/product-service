package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {

    PRODUCT_CREATE("ProductCreate", "상품 생성"),
    PRODUCT_UPDATE("ProductUpdate", "상품 수정"),
    PRODUCT_DELETE("ProductDelete", "상품 삭제"),
    ;

    private final String name;
    private final String label;
}
