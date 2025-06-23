package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlResponseVo;
import com.chalnakchalnak.product_service.adapter.in.vo.PresignedUrlRequestVo;
import com.chalnakchalnak.product_service.adapter.in.vo.SaveImageUrlRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class PresignedUrlVoMapper {

    public PresignedUrlRequestDto toPresignedUrlRequestDto(PresignedUrlRequestVo presignedUrlRequestVo, String memberUuid) {
        String ext = presignedUrlRequestVo.getContentType()
                .substring(presignedUrlRequestVo.getContentType().indexOf("/") + 1);

        String key = "product/" + memberUuid + "/images/" + UUID.randomUUID() + "." + ext;

        return PresignedUrlRequestDto.builder()
                .key(key)
                .contentType(presignedUrlRequestVo.getContentType())
                .build();
    }

    public PresignedUrlResponseDto toPresignedUrlResponseDto(String url, Map<String, String> fields) {
        return PresignedUrlResponseDto.builder()
                .url(url)
                .fields(fields)
                .build();
    }

    public PresignedUrlResponseVo toPresignedResponseVo(PresignedUrlResponseDto presignedUrlResponseDto) {
        return PresignedUrlResponseVo.builder()
                .url(presignedUrlResponseDto.getUrl())
                .fields(presignedUrlResponseDto.getFields())
                .build();
    }

    public SaveImageUrlRequestDto toSaveImageUrlRequestDto(SaveImageUrlRequestVo saveImageUrlRequestVo) {
        return SaveImageUrlRequestDto.builder()
                .key(saveImageUrlRequestVo.getKey())
                .productUuid(saveImageUrlRequestVo.getProductUuid())
                .order(saveImageUrlRequestVo.getOrder())
                .build();
    }
}
