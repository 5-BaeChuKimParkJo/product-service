package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.in.web.mapper.PresignedUrlVoMapper;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.repository.ProductImageRepository;
import com.chalnakchalnak.product_service.application.mapper.PresignedUrlServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.S3UseCase;
import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import com.chalnakchalnak.product_service.domain.ProductImageDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service implements S3UseCase {

    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final PresignedUrlVoMapper presignedUrlVoMapper;
    private final PresignedUrlServiceMapper presignedUrlServiceMapper;
    private final S3Presigner s3Presigner;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Override
    public PresignedUrlResponseDto generatePresignedUrl(PresignedUrlRequestDto presignedUrlRequestDto) {
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(presignedUrlRequestDto.getFileName())
                .contentType(presignedUrlRequestDto.getContentType())
                .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(5)) // 5분 유효
                .putObjectRequest(objectRequest)
                .build();

        PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);

        String presignedUrl = presignedRequest.url().toString();
        String uploadFileUrl = "https://" + bucket + ".s3." + region + ".amazonaws.com/" + presignedUrlRequestDto.getFileName();

        return presignedUrlVoMapper.toPresignedUrlResponseDto(presignedUrl, uploadFileUrl);
    }

    @Override
    public void saveImageUrl(SaveImageUrlRequestDto saveImageUrlRequestDto) {
        ProductImageDomain productImageDomain = presignedUrlServiceMapper.toProductImageDomain(saveImageUrlRequestDto);
        
        // 썸네일 수정
        if (productImageDomain.getIndex() == 1) {

            productRepositoryPort.updateProduct(ProductUpdateSaveDto.builder()
                                                .productUuid(saveImageUrlRequestDto.getProductUuid())
                                                .thumbnailUrl(saveImageUrlRequestDto.getPresignedUrl()).build());
        }

        productImageRepositoryPort
                .uploadImageUrl(presignedUrlServiceMapper.toProductImageUrlSaveDto(productImageDomain));
    }
}
