package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.DealCompleteRequestVo;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.DealVoMapper;
import com.chalnakchalnak.product_service.application.port.in.DealUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.event.DealCompleteRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Product", description = "상품 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class DealController {

    private final DealUseCase dealCompleteUseCase;
    private final DealVoMapper dealVoMapper;

    @Operation(summary = "거래 완료")
    @PostMapping("/complete")
    public void completeDeal(@RequestBody DealCompleteRequestVo dealCompleteRequestVo) {

        dealCompleteUseCase.completeDeal(dealVoMapper.toDealCompleteRequestDto(dealCompleteRequestVo));


        // 판매자 uuid, 판매자 닉네임,
        // 구매자 uuid, 구매자 닉네임
        // 상품 uuid, 상품 게시글 제목, 게시글 설명, 직접 거래 여부, 직접 거래 장소, 상품 상태, 상품 가격
        // 거래 시작 시간, 거래 완료 시간
    }
}
