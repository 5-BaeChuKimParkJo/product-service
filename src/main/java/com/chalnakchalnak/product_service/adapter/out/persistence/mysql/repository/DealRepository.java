package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.mapper.DealCompleteEntityMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.DealCompleteSaveDto;
import com.chalnakchalnak.product_service.application.port.out.DealRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DealRepository implements DealRepositoryPort {

    private final DealJpaRepository dealJpaRepository;
    private final DealCompleteEntityMapper dealCompleteEntityMapper;


    @Override
    public void saveDealComplete(DealCompleteSaveDto dealCompleteSaveDto) {
        dealJpaRepository.save(dealCompleteEntityMapper.toDealCompleteEntity(dealCompleteSaveDto));
    }
}
