package com.chalnakchalnak.product_service.adapter.in.web.mapper;

import com.chalnakchalnak.product_service.adapter.in.vo.ProductRequestVo;
import com.chalnakchalnak.product_service.application.port.in.dto.ProductRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProductVoMapper {

//    private List<String> productImageUrList;
//    private Boolean isDirectDeal;
//    private String directDealLocation;
//    private String title;
//    private String productCondition;
//    private String categoryId;
//    private String productDescription;
//    private String price;
//    private String ticketId;

    public ProductRequestDto toProductRequestDto(ProductRequestVo productRequestVo) {
        return ProductRequestDto.builder()
                .productImageUrList(productRequestVo.getProductImageUrList())
                .isDirectDeal(productRequestVo.getIsDirectDeal())
                .directDealLocation(productRequestVo.getDirectDealLocation())
                .title(productRequestVo.getTitle())
                .productCondition(productRequestVo.getProductCondition())
                .categoryId(productRequestVo.getCategoryId())
                .productDescription(productRequestVo.getProductDescription())
                .price(productRequestVo.getPrice())
                .ticketId(productRequestVo.getTicketId())
                .build();
    }

}
