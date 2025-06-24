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
@Tag(name = "Deal", description = "거래 관련 API")
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
    }
}
