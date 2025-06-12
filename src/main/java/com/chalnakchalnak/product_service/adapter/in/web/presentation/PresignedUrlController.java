package com.chalnakchalnak.product_service.adapter.in.web.presentation;

import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.SaveImageUrlRequestVo;
import com.chalnakchalnak.product_service.adapter.in.web.mapper.PresignedUrlVoMapper;
import com.chalnakchalnak.product_service.application.port.in.PresignedUrlService;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "ProductImage", description = "상품 이미지 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class PresignedUrlController {

    private final PresignedUrlService presignedUrlService;
    private final PresignedUrlVoMapper presignedUrlVoMapper;

    @Operation(summary = "AWS S3 Presigned url 요청")
    @PostMapping("/presigned-url")
    public PresignedUrlResponseVo getPresignedUrl(@RequestBody @Valid PresignedUrlRequestVo presignedUrlRequestVo) {
        PresignedUrlResponseDto presignedUrlResponseDto =
                presignedUrlService.generatePresignedUrl(presignedUrlVoMapper.toPresignedUrlRequestDto(presignedUrlRequestVo));

        return presignedUrlVoMapper.toPresignedResponseVo(presignedUrlResponseDto);
    }

    @Operation(summary = "이미지 url DB저장")
    @PostMapping("/save-image-url")
    public void saveImageUrl(@Valid @RequestBody SaveImageUrlRequestVo saveImageUrlRequestVo) {
        presignedUrlService.saveImageUrl(presignedUrlVoMapper.toSaveImageUrlRequestDto(saveImageUrlRequestVo));
    }

    @Operation(summary = "이미지 url 삭제")
    @DeleteMapping("/delete-image-url")
    public void deleteImageUrl(@RequestParam String productUuid, @RequestParam int idx) {
        presignedUrlService.deleteImageUrl(productUuid, idx);
    }
}
