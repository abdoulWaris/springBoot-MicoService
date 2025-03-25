package com.event.productservice.controller;

import com.event.productservice.dto.ProductRequest;
import com.event.productservice.dto.ProductResponse;
import com.event.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
        var createProduct= productService.createNewProduct(productRequest);
        return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest,
                                           @PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.updateProduct(productRequest,productId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{productId})")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
}
