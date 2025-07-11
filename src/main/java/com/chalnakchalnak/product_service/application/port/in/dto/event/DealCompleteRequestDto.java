package com.chalnakchalnak.product_service.application.port.in.dto.event;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DealCompleteRequestDto {

    private String buyMemberUuid;
    private String productUuid;
    private LocalDateTime dealStartAt;
    private String chatRoomUuid;

    @Builder
    public DealCompleteRequestDto(String buyMemberUuid,
                                  String productUuid,
                                  LocalDateTime dealStartAt,
                                  String chatRoomUuid) {
        this.buyMemberUuid = buyMemberUuid;
        this.productUuid = productUuid;
        this.dealStartAt = dealStartAt;
        this.chatRoomUuid = chatRoomUuid;
    }
}
