package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.out.event.ProductUpdateEvent;
import com.chalnakchalnak.product_service.adapter.out.feign.member.MemberServiceFeignClient;
import com.chalnakchalnak.product_service.adapter.out.feign.member.dto.MemberResponseDto;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import com.chalnakchalnak.product_service.application.mapper.DealServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.DealUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.event.DealCompleteRequestDto;
import com.chalnakchalnak.product_service.application.port.out.DealRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.domain.DealCompleteDomain;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DealService implements DealUseCase {

    private final DealRepositoryPort dealRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final DealServiceMapper dealServiceMapper;
    private final MemberServiceFeignClient memberServiceFeignClient;
    private final ApplicationEventPublisher publisher;

    @Transactional
    @Override
    public void completeDeal(DealCompleteRequestDto dealCompleteRequestDto) {

        DealCompleteDomain dealCompleteDomain = dealServiceMapper.toDealCompleteDomain(dealCompleteRequestDto);

        // 관련 데이터 조회하기
        ProductDomain productDomain = productRepositoryPort.getProduct(dealCompleteRequestDto.getProductUuid());

        MemberResponseDto buyMemberDto = memberServiceFeignClient.getMember(dealCompleteRequestDto.getBuyMemberUuid());
        MemberResponseDto saleMemberDto = memberServiceFeignClient.getMember(productDomain.getSaleMemberUuid());

        // 관련 데이터 조회하기
        dealCompleteDomain.setProductData(productDomain);
        dealCompleteDomain.setNickname(buyMemberDto.getNickname(),
                                        saleMemberDto.getNickname());
        dealCompleteDomain.setDealCompleteAtNow();

        // 거래완료 insert
        dealRepositoryPort.saveDealComplete(dealServiceMapper.toDealCompleteSaveDto(dealCompleteDomain));

        // product 테이블 거래완료 update
        productRepositoryPort.updateProduct(ProductUpdateSaveDto.builder()
                                                    .productUuid(dealCompleteRequestDto.getProductUuid())
                                                    .status(Status.ENDED)
                                                    .build());


        publisher.publishEvent(new ProductUpdateEvent(productRepositoryPort.getProductForOutbox(dealCompleteRequestDto.getProductUuid())));
    }
}
