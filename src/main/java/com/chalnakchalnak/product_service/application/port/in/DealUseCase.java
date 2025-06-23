package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.event.DealCompleteRequestDto;

public interface DealUseCase {

    void completeDeal(DealCompleteRequestDto dealCompleteRequestDto);
}
