package com.springboot.response;

import com.springboot.entity.ProductCategory;
import com.springboot.entity.ProductVariant;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ProductDetails {
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
