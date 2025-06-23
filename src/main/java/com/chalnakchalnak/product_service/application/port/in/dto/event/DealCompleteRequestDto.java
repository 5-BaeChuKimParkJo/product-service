package com.chalnakchalnak.product_service.application.port.in.dto.event;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DealCompleteRequestDto {

    private String saleMemberNickname;
    private String buyMemberUuid;
    private String buyMemberNickname;
    private String productUuid;
    private LocalDateTime dealStartAt;
    private String chatRoomUuid;

    @Builder
    public DealCompleteRequestDto(String saleMemberNickname,
                                  String buyMemberUuid,
                                  String buyMemberNickname,
                                  String productUuid,
                                  LocalDateTime dealStartAt,
                                  String chatRoomUuid) {
        this.saleMemberNickname = saleMemberNickname;
        this.buyMemberUuid = buyMemberUuid;
        this.buyMemberNickname = buyMemberNickname;
        this.productUuid = productUuid;
        this.dealStartAt = dealStartAt;
        this.chatRoomUuid = chatRoomUuid;
    }
}
