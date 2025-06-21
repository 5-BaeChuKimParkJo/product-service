package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.OutboxEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.event.OutboxSaveDto;

import java.util.List;

public interface OutboxRepositoryPort {

    List<OutboxEntity> getPendigOutboxList();

    OutboxEntity saveEvent(OutboxSaveDto outboxSaveDto);

}
