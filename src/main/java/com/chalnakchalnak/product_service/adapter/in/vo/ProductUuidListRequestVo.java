package com.chalnakchalnak.product_service.adapter.in.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductUuidListRequestVo {

    @NotBlank(message = "상품uuid는 필수값 입니다.")
    List<String> productUuidList;
}
