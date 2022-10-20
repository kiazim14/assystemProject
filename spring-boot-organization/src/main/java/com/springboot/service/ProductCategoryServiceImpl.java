package com.springboot.service;

import com.springboot.converter.ProductCategoryResponseConverter;
import com.springboot.dto.ProductCategoryDTO;
import com.springboot.entity.ProductCategory;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.repository.ProductCategoryRepository;
import com.springboot.response.ProductCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;
    private ProductCategoryResponse productCategoryResponse;
    private ProductCategoryDTO productCategoryDTO;
    private ProductCategory productCategory;
    private ProductCategoryResponseConverter productCategoryResponseConverter;


//    @Autowired
//    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository,
//                                      ProductCategoryResponse productCategoryResponse) {
//        this.productCategoryRepository = productCategoryRepository;
//        this.productCategoryResponse = productCategoryResponse;
//    }


    @Override
    public List<ProductCategoryResponse> findAllProductCategory() throws ResourceNotFoundException {
        List<ProductCategory> productCategory = productCategoryRepository.findAllProdCategory();
        if (productCategory == null) {
            throw new ResourceNotFoundException("Could not find productcategory");
        }
        List<ProductCategoryResponse> productCategoryResponse = new ArrayList<>();
        for (ProductCategory prod : productCategory) {
            ProductCategoryResponse res = new ProductCategoryResponse();
            res.setId(prod.getId());
            res.setName(prod.getName());
            productCategoryResponse.add(res);
        }
        return productCategoryResponse;
    }


    @Override
    public ProductCategoryResponse findByProductCategory(Long id) throws ResourceNotFoundException {
        productCategoryRepository.findById(productCategoryResponse.getId())
                .orElseThrow(() -> new ResourceNotFoundException("product_category not found for this id :: "));
        return productCategoryResponse;
    }

    @Override
    public List<ProductCategoryResponse> saveByCategory() throws ResourceNotFoundException {
        List<ProductCategory> productCategories = productCategoryRepository.findByProductCategory();
        if (productCategories.isEmpty()) {
            throw new ResourceNotFoundException("Could not find product categories");
        }

        productCategories.stream()
                .map(productCategoryResponseConverter)
                .collect(Collectors.toList());

        return (List<ProductCategoryResponse>) productCategory;
    }

    @Override
    public List<ProductCategoryResponse> getProCaTegory() {
        List<ProductCategory> entities = productCategoryRepository.getproCaT();

        List<ProductCategoryResponse> result = new ArrayList<>();
          for(ProductCategory entity: entities) {
              ProductCategoryResponse res = new ProductCategoryResponse();
                   res.setId(entity.getId());
                   res.setName(entity.getName());
              result.add(res);
           }
        return result;
    }


//    @Override
//    public ProductCategory saveProductCategory(@Valid ProductCategoryResponse ProductCategoryResponse) throws ResourceNotFoundException {
//         productCategoryRepository.getProductCategoryById(productCategory.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("productCategory"));
//
//       ProductCategory productCategory = new ProductCategory();
//       productCategory.setId(ProductCategoryResponse.getId());
//       productCategory.setName(ProductCategoryResponse.getName());
//       productCategoryRepository.save(productCategory);
//
//       return productCategory;
//    }

//    @Override
//    public ProductCategory save(ProductCategoryResponse productCategoryResponse) {
//        productCategory.setId(productCategoryResponse.getId());
//        productCategory.setName(productCategoryResponse.getName());
//        return productCategoryRepository.save(productCategory);
//    }




//    @Override
//    public ProductCategoryDTO saveProductCategory(@Valid ProductCategoryDTO productCategoryDTO) throws ResourceNotFoundException {
//        ProductCategory proCategory = productCategoryRepository.getOne(id);
//        if (Objects.isNull(proCategory)) {
//            /* handle this exception using {@link RestExceptionHandler} */
//            throw new ResourceNotFoundException(ProductCategory.class, id);
//        }
//           productCategoryRepository.save(productCategory);
//            return new ProductCategoryDTO();
//        }

    }