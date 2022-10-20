package com.springboot.repository;

import com.springboot.entity.ProductCategory;
import com.springboot.response.ProductCategoryResponse;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    Optional<ProductCategory> productCategory = Optional.of(new ProductCategory());

    @Query(value = "SELECT * FROM product_category where id = 'id'", nativeQuery = true)
    static Optional<ProductCategory> findByproductCategoryId(Long category_id) {
        return productCategory;
    }

    public List<ProductCategory> findAllByOrderByName();

    @Query(value = "SELECT * FROM product_category", nativeQuery = true)
    List<ProductCategory> findAllProdCategory();

    @Query(value = "SELECT * FROM product_category where id = 'id'", nativeQuery = true)
    Optional<ProductCategory> getProductCategoryById(Long id);

    @Query(value = "SELECT * FROM product_category where id = 'id'", nativeQuery = true)
    List<ProductCategory> findByProductCategory();

    @Query(value = "SELECT * FROM product_category", nativeQuery = true)
    List<ProductCategory> getproCaT();
}
