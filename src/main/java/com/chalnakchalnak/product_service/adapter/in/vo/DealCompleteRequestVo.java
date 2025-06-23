package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DealCompleteRequestVo {
    private LocalDateTime dealStartAt;
    private String chatRoomUuid;
}
