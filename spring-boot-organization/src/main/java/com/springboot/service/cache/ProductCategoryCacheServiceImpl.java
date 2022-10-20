package com.springboot.service.cache;

import com.springboot.entity.ProductCategory;
import com.springboot.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryCacheServiceImpl implements ProductCategoryCacheService{

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryCacheServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    public List<ProductCategory> findAllByOrderByName() {
        return productCategoryRepository.findAllByOrderByName();
    }
}
