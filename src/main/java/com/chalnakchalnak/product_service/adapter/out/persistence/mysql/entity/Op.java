package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Op {

    C("c", "쓰기"),
    U("", "수정"),
    D("d", "삭제"),
    ;

    private final String name;
    private final String label;
}
