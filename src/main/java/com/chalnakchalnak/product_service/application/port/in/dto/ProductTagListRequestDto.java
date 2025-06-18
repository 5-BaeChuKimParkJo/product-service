package com.chalnakchalnak.product_service.application.port.in.dto;

import lombok.Getter;

@Getter
public class ProductTagListRequestDto {

    private String productUuid;
    private Long tagId;
}
