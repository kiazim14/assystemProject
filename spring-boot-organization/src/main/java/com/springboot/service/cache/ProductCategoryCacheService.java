package com.springboot.service.cache;

import com.springboot.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryCacheService {
    List<ProductCategory> findAllByOrderByName();
}
