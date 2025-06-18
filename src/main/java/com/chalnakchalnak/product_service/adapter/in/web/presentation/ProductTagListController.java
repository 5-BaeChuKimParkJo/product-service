package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductTagListCreateRequestVo;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.ProductTagListVoMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductTagListUseCase;
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

    private final ProductTagListUseCase productTagListUseCase;
    private final ProductTagListVoMapper productTagListVoMapper;

    @Operation(summary = "태그 추가", description = "상품에 포함된 태그를 모두 삭제한 후 다시 저장합니다.")
    @PostMapping
    public void crateProductTagList(@RequestBody @Valid
                                                 ProductTagListCreateRequestVo productTagListCreateRequestVo) {
        productTagListUseCase
                .crateProductTagList(productTagListVoMapper.toProductTagCreateRequestDto(productTagListCreateRequestVo));
    }

    @Operation(summary = "태그 삭제", description = "상품에 포함된 태그를 모두 삭제합니다.")
    @DeleteMapping("/{productUuid}")
    public void getProduct(@PathVariable String productUuid) {
        productTagListUseCase.deleteProductTagListByProductUuid(productUuid);
    }
}
