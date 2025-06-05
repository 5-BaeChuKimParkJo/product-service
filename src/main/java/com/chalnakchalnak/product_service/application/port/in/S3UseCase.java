package com.chalnakchalnak.product_service.application.port.in;

import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;

public interface S3UseCase {

    PresignedUrlResponseDto generatePresignedUrl(PresignedUrlRequestDto presignedUrlRequestDto);

    void saveImageUrl(SaveImageUrlRequestDto saveImageUrlRequestDto);
}
