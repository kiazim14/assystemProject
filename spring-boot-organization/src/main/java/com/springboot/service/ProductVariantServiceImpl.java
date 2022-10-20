package com.springboot.service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductVariantResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private ProductServiceImpl productVariantRepository;
    private ProductVariantResponse productVariantResponse;

    @Override
    public ProductVariantResponse findByProductVariant() throws ResourceNotFoundException {
        productVariantRepository.findById(productVariantResponse.getId())
                .orElseThrow(() -> new ResourceNotFoundException("product_category not found for this id :: " ));
        return productVariantResponse;
    }
}
