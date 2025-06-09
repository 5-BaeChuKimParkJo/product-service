package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductCreateRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductUpdateRequestVo;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.ProductVoMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Product", description = "상품 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductVoMapper productVoMapper;

    @Operation(summary = "상품 엔티티 단일 조회")
    @GetMapping("/{productUuid}")
    public ProductResponseVo getProduct(@PathVariable String productUuid) {
        return productVoMapper.toProductResponseVo(productUseCase.getProduct(productUuid));
    }

    @Operation(summary = "상품 등록")
    @PostMapping
    public void createProduct(@RequestHeader("memberUuid") String memberUuid,
                              @RequestBody ProductCreateRequestVo productRequestVo) {
        productUseCase.createProduct(productVoMapper.toProductCreateRequestDto(productRequestVo, memberUuid));
    }

    @Operation(summary = "상품 수정")
    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRequestVo productUpdateRequestVo) {
        productUseCase.updateProduct(productVoMapper.toProductUpdateRequestDto(productUpdateRequestVo));
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{productUuid}")
    public void deleteProduct(@PathVariable String productUuid) {
        productUseCase.deleteProduct(productUuid);
    }

    @Operation(summary = "일반 상품 이미지 삭제")
    @DeleteMapping("/image")
    public void deleteProductImage() {
    }
}
