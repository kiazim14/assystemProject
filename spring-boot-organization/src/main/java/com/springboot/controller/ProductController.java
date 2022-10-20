package com.springboot.controller;

import com.springboot.dto.ProductDTO;
import com.springboot.entity.Product;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductDetails;
import com.springboot.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@Api(value="product Manage", description="Operations pertaining to product in products Manageme")
public class ProductController {

    private ProductService productService;
    private Product productId;

    @ApiOperation(value = "Get an product by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(
            @ApiParam(value = "Product id from which products object will retrieve", required = true)
            @PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(productService.findById(productId));
    }

    @ApiOperation(value = "View a list of Product", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add an product")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(
            @ApiParam(value = "Product object store in database table", required = true)
            @Valid @RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Update product")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDetails> updateProduct(
            @ApiParam(value = "Product Id to update product object", required = true)
            @PathVariable(value = "id") Long productId,
            @ApiParam(value = "Update product object", required = true)
            @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.updateByProduct(productId));
    }

    @ApiOperation(value = "Delete an employee")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
        // Getting the requiring product; or throwing exception if not found
        final Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product"));

        // Deleting product from the application...
        productService.deleteProduct(product);

        return ResponseEntity.noContent().build();
    }
}