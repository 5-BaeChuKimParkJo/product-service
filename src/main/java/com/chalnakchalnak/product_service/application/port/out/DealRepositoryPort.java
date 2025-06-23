package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.DealCompleteSaveDto;

public interface DealRepositoryPort {

    void saveDealComplete(DealCompleteSaveDto dealCompleteSaveDto);

}
