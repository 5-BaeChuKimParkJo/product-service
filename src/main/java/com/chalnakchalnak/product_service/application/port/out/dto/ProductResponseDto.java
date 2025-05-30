package com.chalnakchalnak.product_service.application.port.out.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.ProductCondition;
import com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private String productUuid;
    private String saleMemberUuid;
    private String title;
    private String categoryId;
    private String categoryName;
    private String description;
    private Status status;
    private ProductCondition productCondition;
    private Boolean isDirectDeal;
    private String directDealLocation;
    private String thumbnailUrl;
    private List<String> productImageUrlList;
    private String nickname;
    private String profileImageUrl;
    private String gradeName;
    private Long likeCount;
    private Long viewCount;
    private LocalDateTime  createdAt;

    @Builder
    public ProductResponseDto(String productUuid,
                              String saleMemberUuid,
                              String title,
                              String categoryId,
                              String categoryName,
                              String description,
                              Status status,
                              ProductCondition productCondition,
                              Boolean isDirectDeal,
                              String directDealLocation,
                              String thumbnailUrl,
                              List<String> productImageUrlList,
                              String nickname,
                              String profileImageUrl,
                              String gradeName,
                              Long likeCount,
                              Long viewCount,
                              LocalDateTime createdAt) {
        this.productUuid = productUuid;
        this.saleMemberUuid = saleMemberUuid;
        this.title = title;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
        this.productCondition = productCondition;
        this.isDirectDeal = isDirectDeal;
        this.directDealLocation = directDealLocation;
        this.thumbnailUrl = thumbnailUrl;
        this.productImageUrlList = productImageUrlList;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.gradeName = gradeName;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
    }

}
