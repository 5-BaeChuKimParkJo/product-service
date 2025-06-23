package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.DealCompleteEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.DealCompleteSaveDto;
import org.springframework.stereotype.Component;

@Component
public class DealCompleteEntityMapper {

    public DealCompleteEntity toDealCompleteEntity(DealCompleteSaveDto dealCompleteSaveDto) {
        return DealCompleteEntity.builder()
                .saleMemberUuid(dealCompleteSaveDto.getSaleMemberUuid())
                .saleMemberNickname(dealCompleteSaveDto.getSaleMemberNickname())
                .buyMemberUuid(dealCompleteSaveDto.getBuyMemberUuid())
                .buyMemberNickname(dealCompleteSaveDto.getBuyMemberNickname())
                .productUuid(dealCompleteSaveDto.getProductUuid())
                .title(dealCompleteSaveDto.getTitle())
                .description(dealCompleteSaveDto.getDescription())
                .isDirectDeal(dealCompleteSaveDto.getIsDirectDeal())
                .directDealLocation(dealCompleteSaveDto.getDirectDealLocation())
                .productCondition(dealCompleteSaveDto.getProductCondition())
                .price(dealCompleteSaveDto.getPrice())
                .dealStartAt(dealCompleteSaveDto.getDealStartAt())
                .dealCompleteAt(dealCompleteSaveDto.getDealCompleteAt())
                .chatroomUuid(dealCompleteSaveDto.getChatroomUuid())
                .build();
    }
}
