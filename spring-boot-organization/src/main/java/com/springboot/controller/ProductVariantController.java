package com.springboot.controller;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.response.ProductVariantResponse;
import com.springboot.service.ProductVariantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value="productVariant Manage", description="Operations pertaining to productVariant in products Manageme")
public class ProductVariantController {

    private ProductVariantService productVariantService;

    @GetMapping(value = "/product_variant/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "View a list of available product_variant", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal_Server_Error, Oops! Something went wrong…")})
    public ResponseEntity<ProductVariantResponse> getProductVariant() throws ResourceNotFoundException {
        ProductVariantResponse productVariant = productVariantService.findByProductVariant();
        return new ResponseEntity<>(productVariant, HttpStatus.OK);
    }

}
