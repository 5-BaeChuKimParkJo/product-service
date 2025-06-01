package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.QProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateRequestDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements ProductJpaCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    @Transactional
    public long updateProductDynamic(ProductUpdateRequestDto productUpdateRequestDto) {
        QProductEntity c = QProductEntity.productEntity;

        var update = queryFactory.update(c);

        // 동적 업데이트 구성
        if (productUpdateRequestDto.getTitle() != null) {
            update.set(c.title, productUpdateRequestDto.getTitle());
        }
        if (productUpdateRequestDto.getCategoryId() != null) {
            update.set(c.categoryId, productUpdateRequestDto.getCategoryId());
        }
        if (productUpdateRequestDto.getDescription() != null) {
            update.set(c.description, productUpdateRequestDto.getDescription());
        }
        if (productUpdateRequestDto.getProductCondition() != null) {
            update.set(c.productCondition, productUpdateRequestDto.getProductCondition());
        }
        if (productUpdateRequestDto.getIsDirectDeal() != null) {
            update.set(c.isDirectDeal, productUpdateRequestDto.getIsDirectDeal());
        }
        if (productUpdateRequestDto.getDirectDealLocation() != null || productUpdateRequestDto.getDirectDealLocation() == null) {
            update.set(c.directDealLocation, productUpdateRequestDto.getDirectDealLocation());
        }
        if (productUpdateRequestDto.getIsHide() != null) {
            update.set(c.isHide, productUpdateRequestDto.getIsHide());
        }
        if (productUpdateRequestDto.getStatus() != null) {
            update.set(c.status, productUpdateRequestDto.getStatus());
        }
        if (productUpdateRequestDto.getThumbnailUrl() != null) {
            update.set(c.thumbnailUrl, productUpdateRequestDto.getThumbnailUrl());
        }
        if (productUpdateRequestDto.getPrice() != null) {
            update.set(c.price, productUpdateRequestDto.getPrice());
        }
        if (productUpdateRequestDto.getTicketUuid() != null || productUpdateRequestDto.getTicketUuid() == null) {
            update.set(c.ticketUuid, productUpdateRequestDto.getTicketUuid());
        }
        // 필수 조건: 어떤 엔티티를 업데이트할지 지정
        return update
                .where(c.productUuid.eq(productUpdateRequestDto.getProductUuid()))
                .execute();
    }

}
