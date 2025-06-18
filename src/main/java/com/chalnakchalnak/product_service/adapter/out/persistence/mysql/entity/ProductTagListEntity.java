package com.chalnakchalnak.product_service.adapter.out.persistence.mysql.entity;


import com.chalnakchalnak.product_service.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_tag_list")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductTagListEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "product_uuid", nullable = false, length = 50)
    private String productUuid;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "idx", nullable = false)
    private int idx;

    @Builder
    public ProductTagListEntity(Long id, String productUuid, Long tagId, int idx) {
        this.id = id;
        this.productUuid = productUuid;
        this.tagId = tagId;
        this.idx = idx;
    }
}
