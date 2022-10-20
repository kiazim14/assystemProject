package com.springboot.repository;

import com.springboot.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends PagingAndSortingRepository<ProductVariant, Long>,
        JpaSpecificationExecutor<ProductVariant> {
}
