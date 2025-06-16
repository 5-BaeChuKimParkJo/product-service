package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository.custom;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.QProductEntity;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements ProductJpaCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    @Transactional
    public long updateProductDynamic(ProductUpdateSaveDto productUpdateSaveDto) {

        QProductEntity c = QProductEntity.productEntity;

        var update = queryFactory.update(c);

        // 동적 업데이트 구성
        if (productUpdateSaveDto.getTitle() != null) {
            update.set(c.title, productUpdateSaveDto.getTitle());
        }
        if (productUpdateSaveDto.getCategoryId() != null) {
            update.set(c.categoryId, productUpdateSaveDto.getCategoryId());
        }
        if (productUpdateSaveDto.getDescription() != null) {
            update.set(c.description, productUpdateSaveDto.getDescription());
        }
        if (productUpdateSaveDto.getProductCondition() != null) {
            update.set(c.productCondition, productUpdateSaveDto.getProductCondition());
        }
        if (productUpdateSaveDto.getIsDirectDeal() != null) {
            update.set(c.isDirectDeal, productUpdateSaveDto.getIsDirectDeal());
            if (productUpdateSaveDto.getIsDirectDeal() == false) {
                update.set(c.directDealLocation, "");
            } else {
                update.set(c.directDealLocation, productUpdateSaveDto.getDirectDealLocation());
            }
        }
        if (productUpdateSaveDto.getIsHide() != null) {
            update.set(c.isHide, productUpdateSaveDto.getIsHide());
        }
        if (productUpdateSaveDto.getStatus() != null) {
            update.set(c.status, productUpdateSaveDto.getStatus());
        }
        if (productUpdateSaveDto.getThumbnailKey() != null) {
            update.set(c.thumbnailKey, productUpdateSaveDto.getThumbnailKey());
        }
        if (productUpdateSaveDto.getPrice() != null) {
            update.set(c.price, productUpdateSaveDto.getPrice());
        }
        if (productUpdateSaveDto.getTicketUuid() != null || productUpdateSaveDto.getTicketUuid() == null) {
            update.set(c.ticketUuid, productUpdateSaveDto.getTicketUuid());
        }
        return update
                .where(c.productUuid.eq(productUpdateSaveDto.getProductUuid()))
                .execute();
    }

}
