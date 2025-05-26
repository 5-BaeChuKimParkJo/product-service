package com.chalnakchalnak.product_service.adapter.in.web;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductDetailResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductImageUrlVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductPreviewResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.ProductRequestVo;
import com.chalnakchalnak.product_service.common.entity.BaseResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Product",  description = "상품 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Operation(summary = "상품 미리보기 단일 조회")
    @GetMapping("/preview/{productUuid}")
    public BaseResponseEntity<ProductPreviewResponseVo> getProductPreview(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "상품 미리보기 리스트 조회")
    @GetMapping("/preview/list?sort={sort}")
    public BaseResponseEntity<List<ProductPreviewResponseVo>> getProductPreviewList(@RequestParam String sort) {
        return null;
    }

    @Operation(summary = "상품 상세 조회")
    @GetMapping("/{productUuid}")
    public BaseResponseEntity<ProductDetailResponseVo> getProductDetail(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "일반 상품 이미지 등록")
    @PostMapping("/image")
    public BaseResponseEntity<ProductImageUrlVo> uploadProductImage() {
        return null;
    }

    @Operation(summary = "일반 상품 이미지 삭제")
    @DeleteMapping("/image")
    public BaseResponseEntity<Void> deleteProductImage() {
        return null;
    }

    @Operation(summary = "상품 등록")
    @PostMapping
    public BaseResponseEntity<Void> createProduct(@RequestBody ProductRequestVo productRequestVo) {
        return null;
    }

    @Operation(summary = "상품 수정")
    @PutMapping
    public BaseResponseEntity<Void> updateProduct(@RequestBody ProductRequestVo productRequestVo) {
        return null;
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{productUuid}")
    public BaseResponseEntity<Void> deleteProduct(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "상품 찜하기")
    @PutMapping("/like/{productUuid}")
    public BaseResponseEntity<Void> likeProduct(@PathVariable String productUuid) {
        return null;
    }

    @Operation(summary = "추천 상품 내역 조회(일반)")
    @GetMapping("/recommend")
    public BaseResponseEntity<List<ProductPreviewResponseVo>> getRecommendedProductList() {
        return null;
    }
}
