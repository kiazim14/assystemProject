package com.springboot.converter;

import com.springboot.entity.ProductVariant;
import com.springboot.response.ProductVariantResponse;

import java.util.function.Function;

public interface ProductVariantResponseConverter extends Function<ProductVariant, ProductVariantResponse> {
}
