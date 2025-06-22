package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.out.event.ProductUpdateEvent;
import com.chalnakchalnak.product_service.application.mapper.ProductTagListServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductTagListUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import com.chalnakchalnak.product_service.domain.ProductDomain;
import com.chalnakchalnak.product_service.domain.ProductTagListDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductTagListService implements ProductTagListUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductTagListRepositoryPort productTagListRepositoryPort;
    private final ProductTagListServiceMapper productTagListServiceMapper;
    private final ApplicationEventPublisher publisher;

    @Override
    @Transactional
    public void crateProductTagList(ProductTagListCreateRequestDto productTagListCreateRequestDto) {

        productTagListRepositoryPort.getProductTagListByProductUuid(productTagListCreateRequestDto.getProductUuid())
                .stream()
                .forEach(productTagListEntity -> productTagListRepositoryPort.deleteProductTagList(productTagListEntity));

        int idx = 0;
        for (Long tagId : productTagListCreateRequestDto.getTagIdList()) {
            ProductTagListDomain productTagListDomain
                    = productTagListServiceMapper
                            .toProductTagListDomain(productTagListCreateRequestDto.getProductUuid(), tagId);
            productTagListDomain.setIdx(++idx);
            productTagListRepositoryPort
                    .createProductTagList(productTagListServiceMapper.toProductTagListSaveDto(productTagListDomain));
        }

        ProductDomain productDomain = productRepositoryPort.getProduct(productTagListCreateRequestDto.getProductUuid());
        ProductUpdateEvent productUpdateEvent = new ProductUpdateEvent(productDomain);

        publisher.publishEvent(productUpdateEvent);
    }

    @Override
    @Transactional
    public void deleteProductTagListByProductUuid(String productUuid) {
        productTagListRepositoryPort.getProductTagListByProductUuid(productUuid)
                .stream()
                .forEach(productTagListEntity -> productTagListRepositoryPort.deleteProductTagList(productTagListEntity));

        publisher.publishEvent(new ProductUpdateEvent(productRepositoryPort.getProduct(productUuid)));
    }
}
