package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;

public interface OutboxRepositoryPort {

    void saveEvent(OutboxSaveDto outboxSaveDto);
}
