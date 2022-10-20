package com.springboot.service;



import com.springboot.dto.ProductDTO;
import com.springboot.entity.Product;
import com.springboot.entity.ProductVariant;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.ProductRepository;
import com.springboot.converter.ProductConverter;
import com.springboot.response.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private int i;
    private ProductDetails productDetails;
    private ProductConverter productConverter;
    private ProductVariant[] product;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product updateByProduct(Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        Product productDetails = new Product();
        productDetails.setId(product.getId());
        productDetails.setName(product.getName());
        productDetails.setSku(product.getSku());
        productDetails.setLastUpdated(product.getLastUpdated());
        productDetails.setLongDesc(product.getLongDesc());
        productDetails.setUnlimited(product.getUnlimited());
        productDetails.setUrl(product.getUrl());
        productDetails.setDateCreated(product.getDateCreated());
        productDetails.setProductCategory(product.getProductCategory());
        productDetails.setProductVariantList(product.getProductVariantList());

        productConverter.apply(productDetails);

        return productRepository.save(product);

    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductCategory(productDTO.getProductCategory());
        product.setProductVariantList(productDTO.getProductVariantList());
        product.setName(productDTO.getName());
        product.setSku(productDTO.getSku());
        product.setDateCreated(productDTO.getDateCreated());
        product.setUnlimited(productDTO.getUnlimited());
        product.setLongDesc(productDTO.getLongDesc());
        product.setUrl(productDTO.getUrl());
        product.setLastUpdated(productDTO.getLastUpdated());
        productRepository.save(product);
    }


//    private void getProductCategory(ProductCategory productCategory) {
//        product.setId(productCategory.getId());
//        productDetails.setName(productCategory.getName());
//    }
//
//    private void getProductVariant(ProductVariant productvariant) {
//        List<ProductVariant> productVariantList = new ArrayList<>();
//        for (ProductVariant prods : product) {
//            ProductVariant productVariant = new ProductVariant();
//            productVariant.setId(prods.getId());
//            productVariant.setProduct(prods.getProduct());
//            productVariant.setColor(prods.getColor());
//            productVariant.setWidth(prods.getWidth());
//            productVariant.setHeight(prods.getHeight());
//            productVariant.setComposition(prods.getComposition());
//            productVariant.setCargoPrice(prods.getCargoPrice());
//            productVariant.setLive(prods.getLive());
//            productVariant.setSellCount(prods.getSellCount());
//            productVariant.setPrice(prods.getPrice());
//            productVariant.setTaxPercent(prods.getTaxPercent());
//            productVariant.setImage(prods.getImage());
//            productVariant.setThumb(prods.getThumb());
//            productVariant.setStock(prods.getStock());
//            productVariantList.add(productVariant);
//        }
//        productDetails.setProductVariantList(productVariantList);
//    }

}
