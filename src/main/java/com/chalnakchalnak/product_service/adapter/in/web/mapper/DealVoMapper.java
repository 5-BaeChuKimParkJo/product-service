package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.DealCompleteRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.event.DealCompleteRequestDto;
import org.springframework.stereotype.Component;

@Component
public class DealVoMapper {

    public DealCompleteRequestDto toDealCompleteRequestDto(DealCompleteRequestVo dealCompleteRequestVo) {
        return DealCompleteRequestDto.builder()
                .buyMemberUuid(dealCompleteRequestVo.getBuyMemberUuid())
                .productUuid(dealCompleteRequestVo.getProductUuid())
                .dealStartAt(dealCompleteRequestVo.getDealStartAt())
                .chatRoomUuid(dealCompleteRequestVo.getChatRoomUuid())
                .build();
    }
}
