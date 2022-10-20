package com.springboot.controller;

import com.springboot.entity.ProductCategory;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductCategoryResponse;
import com.springboot.service.ProductCategoryService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Api(value="productCategory Manage", description="Operations pertaining to productCategory in products Manageme")
@Slf4j
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/productCategory", produces = "application/json")
    @ApiOperation(value = "${swagger.controller.productCategory.getProductCategory.value}", authorizations = {@Authorization(value = "basicAuth")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Controller is successfully launched", response = ProductCategoryResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid_Request"),
            @ApiResponse(code = 401, message = "no_credentials, You must be authenticated"),
            @ApiResponse(code = 403, message = "Protected_Resource, You need sufficient rights"),
            @ApiResponse(code = 404, message = "Not_Found, This dex regate code does not exist"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    public @ResponseBody
    ResponseEntity<List<ProductCategoryResponse>> getProductCategory() {
        try {
            List<ProductCategoryResponse> response = this.productCategoryService.getProCaTegory();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
        } catch (Exception e) {
            log.error("error while getting entity" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/category")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "${swagger.controller.productCategory.saveCategories.value}", authorizations = {@Authorization(value = "basicAuth")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
                @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    public ResponseEntity<List<ProductCategoryResponse>> saveCategories() throws ResourceNotFoundException {
        List<ProductCategoryResponse> productCategories = productCategoryService.saveByCategory();
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

//    @GetMapping(value = "/product_category/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(value = "View a list of available product_category", response = List.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
//            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
//    public ResponseEntity<ProductCategoryResponse> getProductCategory(
//            @ApiParam(value = "Product id from which products object will retrieve", required = true)
//            @PathVariable(value = "id") Long id) throws ResourceNotFoundException {
//        try {
//            ProductCategoryResponse productCategory = productCategoryService.findByProductCategory(id);
//            return ResponseEntity.ok().body(productCategory);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

//    @GetMapping(value = "/product_category")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(value = "View a list of available product_category", response = List.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
//            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
//    public ResponseEntity<List<ProductCategoryResponse>> getAllProductCategory() throws ResourceNotFoundException {
//        try {
//            List<ProductCategoryResponse> productCategory = productCategoryService.findAllProductCategory();
//            return ResponseEntity.ok().body(productCategory);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//        @PostMapping("/product_category")
//        @ResponseStatus(HttpStatus.OK)
//        @ApiOperation(value = "Add an product_category")
//        @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
//                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
//                @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
//        public ResponseEntity<?> saveProductCategory (
//                @ApiParam(value = "product_category object store in database table", required = true)
//                @Valid @RequestBody ProductCategoryResponse productCategoryResponse) throws ResourceNotFoundException {
//            try {
//                return new ResponseEntity<>(productCategoryService.saveProductCategory(productCategoryResponse), HttpStatus.OK);
//            } catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//            }
//        }
    }

