package com.chalnakchalnak.product_service.adapter.out.feign.member;

import com.chalnakchalnak.product_service.adapter.out.feign.member.dto.MemberResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "member-service",
        url = "https://api.cabbage-secondhand.shop", // <- 여기에만 도메인 지정
        path = "/member-service/api/v1" // <- 경로는 여기에
)
public interface MemberServiceFeignClient {

    @GetMapping("/member/{memberUuid}")
    MemberResponseDto getMember(@PathVariable String memberUuid);
}
