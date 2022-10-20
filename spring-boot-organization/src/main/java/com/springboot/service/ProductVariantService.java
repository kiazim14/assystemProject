package com.springboot.service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductVariantResponse;

public interface ProductVariantService {

    ProductVariantResponse findByProductVariant() throws ResourceNotFoundException;
}
