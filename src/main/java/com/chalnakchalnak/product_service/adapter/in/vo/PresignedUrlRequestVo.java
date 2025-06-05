package com.chalnakchalnak.product_service.adapter.in.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class PresignedUrlRequestVo {

    @NotBlank(message = "파일 이름은 필수입니다.")
    private String fileName;

    @NotBlank(message = "파일 형식은 필수입니다.")
    @Pattern(
            regexp = "image/(png|jpeg|webp|bmp)",
            message = "지원하지 않는 이미지 형식입니다."
    )
    private String contentType;
}
