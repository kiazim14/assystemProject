package com.springboot.repository;

import com.springboot.entity.Product;
import com.springboot.response.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
