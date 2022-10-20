package com.springboot.converter;

import com.springboot.entity.Product;
import com.springboot.response.ProductDetails;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductConverter implements Function<ProductDetails, Product> {
    @Override
    public Product apply(ProductDetails productDetails) {
        Product product = new Product();
        product.setId(productDetails.getId());
        product.setProductCategory(productDetails.getProductCategory());
        product.setProductVariantList(productDetails.getProductVariantList());
        product.setName(productDetails.getName());
        product.setSku(productDetails.getSku());
        product.setLongDesc(productDetails.getLongDesc());
        product.setDateCreated(productDetails.getDateCreated());
        product.setUnlimited(productDetails.getUnlimited());
        product.setLastUpdated(productDetails.getLastUpdated());
        product.setUrl(productDetails.getUrl());
        return product;

    }
//
//    @Override
//    public Product apply(ProductDetails product) {
//        Product productDetails = new Product();
//        product.setId(productDetails.getId());
//        product.setProductCategory(productDetails.getProductCategory());
//        product.setProductVariantList(productDetails.getProductVariantList());
//        product.setName(productDetails.getName());
//        product.setSku(productDetails.getSku());
//        product.setLongDesc(productDetails.getLongDesc());
//        product.setDateCreated(productDetails.getDateCreated());
//        product.setUnlimited(productDetails.getUnlimited());
//        product.setLastUpdated(productDetails.getLastUpdated());
//        product.setUrl(productDetails.getUrl());
//        return product;
//    }
//
}
