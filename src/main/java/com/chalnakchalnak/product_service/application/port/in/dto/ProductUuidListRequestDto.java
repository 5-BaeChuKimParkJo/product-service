package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductUuidListRequestDto {

    List<String> productUuidList;

    @Builder
    public ProductUuidListRequestDto(List<String> productUuidList) {
        this.productUuidList = productUuidList;
    }
}
