package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "presigned_url", unique = true, nullable = false)
    private String presignedUrl;

    @Column(name = "upload_file_url", unique = true, nullable = false)
    private String uploadFileUrl;

    @Column(name = "product_uuid", nullable = false)
    private String productUuid;

    @Column(name = "index", nullable = false)
    private int index;

    @Builder
    public ProductImageEntity(Long id,
                              String presignedUrl,
                              String uploadFileUrl,
                              String productUuid,
                              int index) {
        this.id = id;
        this.presignedUrl = presignedUrl;
        this.uploadFileUrl = uploadFileUrl;
        this.productUuid = productUuid;
        this.index = index;
    }

}
