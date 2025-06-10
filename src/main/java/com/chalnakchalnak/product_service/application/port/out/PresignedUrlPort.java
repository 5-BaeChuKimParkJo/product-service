package com.chalnakchalnak.product_service.application.port.out;

import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

public interface PresignedUrlPort {

    PresignedPutObjectRequest generateUrl(PresignedUrlRequestDto presignedUrlRequestDto);
}
