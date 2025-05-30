package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductDetailResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductImageUrlVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductPreviewResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductRequestVo;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.ProductVoMapper;
import com.chalnakchalnak.product_service.application.port.in.ProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "상품 미리보기 단일 조회")
    @GetMapping("/preview/{productUuid}")
    public ProductPreviewResponseVo getProductPreview(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "상품 미리보기 리스트 조회")
    @GetMapping("/preview/list?sort={sort}")
    public List<ProductPreviewResponseVo> getProductPreviewList(@RequestParam String sort) {
        return null;
    }

    @Operation(summary = "상품 상세 조회")
    @GetMapping("/{productUuid}")
    public ProductDetailResponseVo getProductDetail(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "일반 상품 이미지 등록")
    @PostMapping("/image")
    public ProductImageUrlVo uploadProductImage(@RequestHeader("memberUuid") String memberUuid,
                                                @RequestBody ProductRequestVo productRequestVo) {
        return null;
    }

    @Operation(summary = "일반 상품 이미지 삭제")
    @DeleteMapping("/image")
    public void deleteProductImage() {
    }

    @Operation(summary = "상품 등록")
    @PostMapping
    public Void createProduct(@RequestBody ProductRequestVo productRequestVo) {
        productUseCase.createProduct(productVoMapper.toProductRequestDto(productRequestVo));
        return null;
    }

    @Operation(summary = "상품 수정")
    @PutMapping
    public void updateProduct(@RequestBody ProductRequestVo productRequestVo) {
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{productUuid}")
    public void deleteProduct(@PathVariable String productUuid) {
    }

    @Operation(summary = "상품 찜하기")
    @PutMapping("/like/{productUuid}")
    public void likeProduct(@PathVariable String productUuid) {
    }

    @Operation(summary = "추천 상품 내역 조회(일반)")
    @GetMapping("/recommend")
    public List<ProductPreviewResponseVo> getRecommendedProductList() {
        return null;
    }
}
