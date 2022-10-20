package com.springboot.converter;

import com.springboot.dto.ProductCategoryDTO;
import com.springboot.entity.ProductCategory;
import com.springboot.response.ProductCategoryResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductCategoryResponseConverterImpl implements Function<ProductCategory, ProductCategoryResponse> {

    @Override
    public ProductCategoryResponse apply(ProductCategory productCategory) {
        ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse();
        productCategoryResponse.setName(productCategory.getName());
        return productCategoryResponse;
    }
}
