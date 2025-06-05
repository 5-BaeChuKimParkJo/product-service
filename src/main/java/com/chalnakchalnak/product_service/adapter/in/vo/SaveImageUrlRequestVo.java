package com.chalnakchalnak.product_service.adapter.in.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveImageUrlRequestVo {

    private String presignedUrl;
    private String uploadFileUrl;
    private String productUuid;
    private int index;
}
