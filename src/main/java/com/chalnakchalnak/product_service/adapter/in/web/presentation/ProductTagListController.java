package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductTagCreateRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "ProductTagList", description = "상품-태그 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product/tag")
public class ProductTagListController {

  //  private final ProductTagListUseCase productTagListUseCase;

    @Operation(summary = "태그 추가")
    @PostMapping
    public ProductResponseVo crateProductTagList(@RequestBody @Valid
                                                     ProductTagCreateRequestVo productTagCreateRequestVo) {
        return null;
    }

    @Operation(summary = "태그 삭제")
    @DeleteMapping
    public ProductResponseVo getProduct(@RequestParam String productUuid, @RequestParam int idx) {
        return null;
    }
}
