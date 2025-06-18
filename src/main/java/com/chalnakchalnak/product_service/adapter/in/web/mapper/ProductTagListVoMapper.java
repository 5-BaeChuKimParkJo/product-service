package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductTagListCreateRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductTagListCreateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProductTagListVoMapper {

    public ProductTagListCreateRequestDto toProductTagCreateRequestDto(ProductTagListCreateRequestVo productTagListCreateRequestVo) {
        return ProductTagListCreateRequestDto.builder()
                .tagIdList(productTagListCreateRequestVo.getTagIdList())
                .productUuid(productTagListCreateRequestVo.getProductUuid())
                .build();
    }
}
