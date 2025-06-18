package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.application.mapper.ProductTagListServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductTagListUseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductTagListRepositoryPort;
import com.chalnakchalnak.product_service.domain.ProductTagListDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductTagListService implements ProductTagListUseCase {

    private final ProductTagListRepositoryPort productTagListRepositoryPort;
    private final ProductTagListServiceMapper productTagListServiceMapper;

    @Override
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
    }

    @Override
    public void deleteProductTagListByProductUuid(String productUuid) {
        productTagListRepositoryPort.getProductTagListByProductUuid(productUuid)
                .stream()
                .forEach(productTagListEntity -> productTagListRepositoryPort.deleteProductTagList(productTagListEntity));
    }
}
