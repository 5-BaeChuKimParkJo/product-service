package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.SaveImageUrlRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PresignedUrlVoMapper {

    public PresignedUrlRequestDto toPresignedUrlRequestDto(PresignedUrlRequestVo presignedUrlRequestVo) {
        return PresignedUrlRequestDto.builder()
                .fileName(presignedUrlRequestVo.getFileName())
                .contentType(presignedUrlRequestVo.getContentType())
                .build();
    }

    public PresignedUrlResponseDto toPresignedUrlResponseDto(String presignedUrl, String uploadFileUrl) {
        return PresignedUrlResponseDto.builder()
                .presignedUrl(presignedUrl)
                .uploadFileUrl(uploadFileUrl)
                .build();
    }

    public PresignedUrlResponseVo toPresignedResponseVo(PresignedUrlResponseDto presignedUrlResponseDto) {
        return PresignedUrlResponseVo.builder()
                .presignedUrl(presignedUrlResponseDto.getPresignedUrl())
                .uploadFileUrl(presignedUrlResponseDto.getUploadFileUrl())
                .build();
    }

    public SaveImageUrlRequestDto toSaveImageUrlRequestDto(SaveImageUrlRequestVo saveImageUrlRequestVo) {
        return SaveImageUrlRequestDto.builder()
                .presignedUrl(saveImageUrlRequestVo.getPresignedUrl())
                .uploadFileUrl(saveImageUrlRequestVo.getUploadFileUrl())
                .productUuid(saveImageUrlRequestVo.getProductUuid())
                .index(saveImageUrlRequestVo.getIndex())
                .build();
    }
}
