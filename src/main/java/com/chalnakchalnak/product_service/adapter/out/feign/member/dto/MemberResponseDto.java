package com.chalnakchalnak.product_service.adapter.out.feign.member.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private String memberUuid;
    private String nickname;
    private String gradeUuid;
    private String honor;
    private String state;
    private String profileImageUrl;
    private Double point;
}
