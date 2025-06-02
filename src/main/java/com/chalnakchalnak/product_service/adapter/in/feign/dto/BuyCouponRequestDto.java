package com.chalnakchalnak.product_service.adapter.in.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class BuyCouponRequestDto {

    private String memberUuid;
    private String productUuid;
    private String couponUuid;
}
