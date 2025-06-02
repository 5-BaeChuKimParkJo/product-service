package com.chalnakchalnak.product_service.adapter.in.feign;

import com.chalnakchalnak.product_service.adapter.in.feign.dto.BuyCouponRequestDto;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Product", description = "상품 관련 FEIGN API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product/feign")
public class ProductFeignController {

    private final ProductUseCase productUseCase;

    @PostMapping("/buy")
    public Boolean buyCoupon(@RequestBody BuyCouponRequestDto buyCouponRequestDto) {

        return productUseCase.buyCoupon(buyCouponRequestDto);
    }
}
