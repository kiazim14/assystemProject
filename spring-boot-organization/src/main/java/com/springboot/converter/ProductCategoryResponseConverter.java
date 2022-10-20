package com.springboot.converter;

import com.springboot.entity.ProductCategory;
import com.springboot.response.ProductCategoryResponse;

import java.util.function.Function;

public interface ProductCategoryResponseConverter extends Function<ProductCategory, ProductCategoryResponse> {
}
