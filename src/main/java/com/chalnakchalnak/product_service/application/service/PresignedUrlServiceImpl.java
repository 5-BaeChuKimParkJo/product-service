package com.chalnakchalnak.product_service.application.service;

import com.chalnakchalnak.product_service.application.mapper.PresignedUrlServiceMapper;
import com.chalnakchalnak.product_service.application.port.in.dto.PresignedUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductUpdateSaveDto;
import com.chalnakchalnak.product_service.application.port.in.dto.SaveImageUrlRequestDto;
import com.chalnakchalnak.product_service.application.port.out.ProductImageRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.ProductRepositoryPort;
import com.chalnakchalnak.product_service.application.port.out.dto.PresignedUrlResponseDto;
import com.chalnakchalnak.product_service.common.entity.BaseResponseStatus;
import com.chalnakchalnak.product_service.common.exception.BaseException;
import com.chalnakchalnak.product_service.domain.ProductImageDomain;
import com.chalnakchalnak.product_service.util.PresignedUrlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PresignedUrlServiceImpl implements com.chalnakchalnak.product_service.application.port.in.PresignedUrlService {

    private final ProductImageRepositoryPort productImageRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final PresignedUrlServiceMapper presignedUrlServiceMapper;

    private final String algorithm = "AWS4-HMAC-SHA256";
    private final String service = "s3";

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Override
    public PresignedUrlResponseDto generatePresignedUrl(PresignedUrlRequestDto presignedUrlRequestDto) {

        // 날짜 형식
        Date now = new Date();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMdd");
        dateFmt.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = dateFmt.format(now);

        SimpleDateFormat dateTimeFmt = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        dateTimeFmt.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateTime = dateTimeFmt.format(now);

        // Credential
        String credential = this.accessKey + "/" + date + "/" + this.region + "/" + this.service + "/aws4_request";

        // Policy 문서 생성
        String policyDoc = PresignedUrlUtil.generateDoc(this.bucket,
                this.algorithm,
                credential,
                dateTime,
                presignedUrlRequestDto.getContentType());

        // Policy 인코딩
        Base64.Encoder encoder = Base64.getEncoder();
        String policy = encoder.encodeToString(policyDoc.getBytes(StandardCharsets.UTF_8));

        // 서명 키 생성
        byte[] signingKey = PresignedUrlUtil.getSignatureKey(this.secretKey, date, this.region, this.service);

        // Signature 생성
        String signature = PresignedUrlUtil.bytesToHex(PresignedUrlUtil.hmacSha256(signingKey, policy));

        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("key", presignedUrlRequestDto.getKey());
        fields.put("Content-Type", presignedUrlRequestDto.getContentType());
        fields.put("bucket", this.bucket);
        fields.put("X-Amz-Algorithm", this.algorithm);
        fields.put("X-Amz-Credential", credential);
        fields.put("X-Amz-Date", dateTime);
        fields.put("Policy", policy);
        fields.put("X-Amz-Signature", signature);

        String url = "https://" + this.bucket + ".s3." + this.region + ".amazonaws.com/";

        return PresignedUrlResponseDto.builder()
                .url(url)
                .fields(fields)
                .build();
    }

    @Override
    @Transactional
    public void saveImageUrl(SaveImageUrlRequestDto saveImageUrlRequestDto) {

        // 상품uuid, idx 존재 -> delete -> insert
        if(productImageRepositoryPort
                .getImageUrl(saveImageUrlRequestDto.getProductUuid(), saveImageUrlRequestDto.getIdx())
                .isPresent()) {
            productImageRepositoryPort
                    .deleteImageKey(saveImageUrlRequestDto.getProductUuid(), saveImageUrlRequestDto.getIdx());
        }

        ProductImageDomain productImageDomain = presignedUrlServiceMapper.toProductImageDomain(saveImageUrlRequestDto);
        // 썸네일 수정
        if (productImageDomain.getIdx() == 1) {
            productRepositoryPort.updateProduct(ProductUpdateSaveDto.builder()
                                                .productUuid(saveImageUrlRequestDto.getProductUuid())
                                                .thumbnailKey(saveImageUrlRequestDto.getImageKey())
                                                .build());
        }
        productImageRepositoryPort
                .uploadImageKey(presignedUrlServiceMapper.toProductImageUrlSaveDto(productImageDomain));
    }

    @Override
    public void deleteImageKey(String productUuid, int idx) {

        // 썸네일 삭제 불가
        if (idx == 1) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_DELETE_THUMBNAIL);
        }
        productImageRepositoryPort.deleteImageKey(productUuid, idx);
    }

    private boolean existsProduct(String productUuid) {
        if (productRepositoryPort.getProduct(productUuid) != null) {
            return true;
        }
        return false;
    }
}
