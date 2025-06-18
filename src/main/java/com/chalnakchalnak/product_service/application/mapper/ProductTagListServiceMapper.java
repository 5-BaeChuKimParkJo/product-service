package com.chalnakchalnak.product_service.application.mapper;

import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListCreateRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListSaveDto;
import com.chalnakchalnak.product_service.domain.ProductTagListDomain;
import org.springframework.stereotype.Component;

@Component
public class ProductTagListServiceMapper {


    public ProductTagListDomain toProductTagListDomain(String productUuid, Long tagId) {
        return ProductTagListDomain.builder()
                .tagId(tagId)
                .productUuid(productUuid)
                .build();
    }

    public ProductTagListSaveDto toProductTagListSaveDto(ProductTagListDomain productTagListDomain) {
        return ProductTagListSaveDto.builder()
                .tagId(productTagListDomain.getTagId())
                .productUuid(productTagListDomain.getProductUuid())
                .idx(productTagListDomain.getIdx())
                .build();
    }
}
