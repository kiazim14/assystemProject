package com.springboot.service;

import com.springboot.dto.ProductDTO;
import com.springboot.entity.Product;
import com.springboot.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    //List<ProductVariantResponse> getAll(Integer page, Integer pageSize, String sort, String category, Float minPrice, Float maxPrice, String color);

    List<Product> findAll();

    Optional<Product> findById(Long productId);

    Product updateByProduct(Long productId) throws ResourceNotFoundException;

    Optional<Product> getProductById(Long id);

    void deleteProduct(Product product);

    void addProduct(ProductDTO productDTO);
}
