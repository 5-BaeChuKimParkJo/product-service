package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "image_key", nullable = false)
    private String imageKey;

    @Column(name = "product_uuid", nullable = false)
    private String productUuid;

    @Column(name = "idx", nullable = false)
    private int idx;

    @Builder
    public ProductImageEntity(Long id,
                              String imageKey,
                              String productUuid,
                              int idx) {
        this.id = id;
        this.imageKey = imageKey;
        this.productUuid = productUuid;
        this.idx = idx;
    }
}
