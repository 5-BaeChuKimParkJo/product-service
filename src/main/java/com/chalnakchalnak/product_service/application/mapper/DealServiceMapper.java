package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.application.port.in.dto.DealCompleteSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.event.DealCompleteRequestDto;
import com.chalnakchalnak.product_service.domain.DealCompleteDomain;
import org.springframework.stereotype.Component;

@Component
public class DealServiceMapper {

    public DealCompleteDomain toDealCompleteDomain(DealCompleteRequestDto dealCompleteRequestDto) {
        return DealCompleteDomain.builder()
                .saleMemberNickname(dealCompleteRequestDto.getSaleMemberNickname())
                .buyMemberUuid(dealCompleteRequestDto.getBuyMemberUuid())
                .buyMemberNickname(dealCompleteRequestDto.getBuyMemberNickname())
                .productUuid(dealCompleteRequestDto.getProductUuid())
                .dealStartAt(dealCompleteRequestDto.getDealStartAt())
                .chatroomUuid(dealCompleteRequestDto.getChatRoomUuid())
                .build();
    }

    public DealCompleteSaveDto toDealCompleteSaveDto(DealCompleteDomain dealCompleteDomain) {
        return DealCompleteSaveDto.builder()
                .saleMemberUuid(dealCompleteDomain.getSaleMemberUuid())
                .saleMemberNickname(dealCompleteDomain.getSaleMemberNickname())
                .buyMemberUuid(dealCompleteDomain.getBuyMemberUuid())
                .buyMemberNickname(dealCompleteDomain.getBuyMemberNickname())
                .productUuid(dealCompleteDomain.getProductUuid())
                .title(dealCompleteDomain.getTitle())
                .description(dealCompleteDomain.getDescription())
                .isDirectDeal(dealCompleteDomain.getIsDirectDeal())
                .directDealLocation(dealCompleteDomain.getDirectDealLocation())
                .productCondition(dealCompleteDomain.getProductCondition())
                .price(dealCompleteDomain.getPrice())
                .dealStartAt(dealCompleteDomain.getDealCompleteAt())
                .dealCompleteAt(dealCompleteDomain.getDealCompleteAt())
                .chatroomUuid(dealCompleteDomain.getChatroomUuid())
                .build();
    }
}
