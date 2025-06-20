package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;

public interface OutboxRepositoryPort {

    void saveEvent(OutboxEntity outboxEntity);
}
