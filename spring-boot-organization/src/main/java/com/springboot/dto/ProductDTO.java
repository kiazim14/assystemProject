package com.springboot.dto;

import com.springboot.entity.ProductCategory;
import com.springboot.entity.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private ProductCategory productCategory;
    private List<ProductVariant> productVariantList;
    private String sku;
    private String name;
    private String url;
    private String longDesc;
    private Date dateCreated;
    private Date  lastUpdated;
    private Integer unlimited;
}
