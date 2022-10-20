package com.springboot.dto;

import com.springboot.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductVariantDTO {

    private Long id;
    private Product product;
    //private Color color;
    private String width;
    private String height;
    private String composition;
    private Float price;
    private Float cargoPrice;
    private Float taxPercent;
    private String image;
    private String thumb;
    private Integer stock;
    private Integer sellCount;
    private Integer live;

}
