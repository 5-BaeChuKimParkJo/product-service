package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.adapter.in.web.mapper.PresignedUrlVoMapper;
import com.chalnakchalnak.product_service.application.mapper.PresignedUrlServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.PresignedUrlService;
import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.PresignedUrlPort;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductImageDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class PresignedUrlServiceImpl implements PresignedUrlService {

    private final PresignedUrlPort presignedUrlPort;
    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final PresignedUrlVoMapper presignedUrlVoMapper;
    private final PresignedUrlServiceMapper presignedUrlServiceMapper;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Override
    public PresignedUrlResponseDto generatePresignedUrl(PresignedUrlRequestDto presignedUrlRequestDto) {

        PresignedPutObjectRequest presignedRequest = presignedUrlPort.generateUrl(presignedUrlRequestDto);

        String presignedUrl = presignedRequest.url().toString();
        String uploadFileUrl = "https://" + bucket + ".s3." + region + ".amazonaws.com/"
                + URLEncoder.encode(presignedUrlRequestDto.getFileName(), StandardCharsets.UTF_8);

        return presignedUrlVoMapper.toPresignedUrlResponseDto(presignedUrl, uploadFileUrl);
    }

    @Override
    @Transactional
    public void saveImageUrl(SaveImageUrlRequestDto saveImageUrlRequestDto) {

        // 상품uuid, idx 존재 -> delete -> insert
        if(productImageRepositoryPort
                .getImageUrl(saveImageUrlRequestDto.getProductUuid(), saveImageUrlRequestDto.getIdx())
                .isPresent()) {
            productImageRepositoryPort
                    .deleteImageUrl(saveImageUrlRequestDto.getProductUuid(), saveImageUrlRequestDto.getIdx());
        }

        ProductImageDomain productImageDomain = presignedUrlServiceMapper.toProductImageDomain(saveImageUrlRequestDto);
        // 썸네일 수정
        if (productImageDomain.getIdx() == 1) {
            productRepositoryPort.updateProduct(ProductUpdateSaveDto.builder()
                                                .productUuid(saveImageUrlRequestDto.getProductUuid())
                                                .thumbnailUrl(saveImageUrlRequestDto.getUploadFileUrl())
                                                .build());
        }
        productImageRepositoryPort
                .uploadImageUrl(presignedUrlServiceMapper.toProductImageUrlSaveDto(productImageDomain));
    }

    @Override
    public void deleteImageUrl(String productUuid, int idx) {

        // 썸네일 삭제 불가
        if (idx == 1) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_DELETE_THUMBNAIL);
        }
        productImageRepositoryPort.deleteImageUrl(productUuid, idx);
    }
}
