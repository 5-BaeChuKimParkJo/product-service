package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.*;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.ProductVoMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Product", description = "상품 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductVoMapper productVoMapper;

    @Operation(summary = "상품 단일 조회")
    @GetMapping("/{productUuid}")
    public ProductResponseVo getProduct(@PathVariable String productUuid) {
        return productVoMapper.toProductResponseVo(productUseCase.getProduct(productUuid));
    }

    @Operation(summary = "상품 다건 조회")
    @PostMapping("/list")
    public List<ProductResponseVo> getProductList(@RequestBody @Valid ProductUuidListRequestVo productUuidListRequestVo) {
        return productUseCase.getProductList(productVoMapper.toProductUuidListRequestDto(productUuidListRequestVo))
                .stream()
                .map(productResponseDto -> productVoMapper.toProductResponseVo(productResponseDto))
                .toList();
    }

    @Operation(summary = "상품 전체 조회")
    @GetMapping("/list")
    public List<ProductResponseVo> getProductList() {
        return productUseCase.getAllProductList()
                .stream()
                .map(productResponseDto -> productVoMapper.toProductResponseVo(productResponseDto))
                .toList();
    }

    @Operation(summary = "숨김 상품 조회")
    @GetMapping("/hide/list")
    public List<ProductResponseVo> getHideProductList(@RequestHeader("X-Member-Uuid") String memberUuid) {
        return productUseCase.getHideProductList(memberUuid)
                .stream()
                .map(productResponseDto -> productVoMapper.toProductResponseVo(productResponseDto))
                .toList();
    }

    @Operation(summary = "상품 등록")
    @PostMapping
    public ProductUuidResponseVo createProduct(@RequestHeader("X-Member-Uuid") String memberUuid,
                                               @RequestBody ProductCreateRequestVo productRequestVo) {
        String productUuid = productUseCase.createProduct(productVoMapper.toProductCreateRequestDto(productRequestVo, memberUuid));
        return productVoMapper.toProductUuidResponseVo(productUuid);
    }

    @Operation(summary = "상품 동적 수정")
    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRequestVo productUpdateRequestVo) {
        productUseCase.updateProduct(productVoMapper.toProductUpdateRequestDto(productUpdateRequestVo));
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{productUuid}")
    public void deleteProduct(@PathVariable String productUuid) {
        productUseCase.deleteProduct(productUuid);
    }

    @Operation(summary = "거래 완료")
    @PostMapping("/complete")
    public void completeDeal(@RequestHeader("X-Member-Uuid") String memberUuid,
                             @RequestBody DealCompleteRequestVo dealCompleteRequestVo) {
        // 판매자 uuid, 판매자 닉네임,
        // 구매자 uuid, 구매자 닉네임
        // 상품 uuid, 상품 게시글 제목, 게시글 설명, 직접 거래 여부, 직접 거래 장소, 상품 상태, 상품 가격
        // 거래 시작 시간, 거래 완료 시간
    }
}
