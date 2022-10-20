package com.springboot.service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductCategoryResponse;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryResponse> findAllProductCategory() throws ResourceNotFoundException;

    ProductCategoryResponse findByProductCategory(Long id) throws ResourceNotFoundException;

    // ProductCategory saveProductCategory(@Valid ProductCategoryResponse productCategoryResponse) throws ResourceNotFoundException;

//    ProductCategory save(ProductCategoryResponse productCategoryResponse);

    List<ProductCategoryResponse> saveByCategory() throws ResourceNotFoundException;

    List<ProductCategoryResponse> getProCaTegory();
}
