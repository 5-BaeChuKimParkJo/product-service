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
    private String key;

    @Column(name = "product_uuid", nullable = false)
    private String productUuid;

    @Column(name = "ord", nullable = false)
    private int order;

    @Builder
    public ProductImageEntity(Long id,
                              String key,
                              String productUuid,
                              int order) {
        this.id = id;
        this.key = key;
        this.productUuid = productUuid;
        this.order = order;
    }
}
