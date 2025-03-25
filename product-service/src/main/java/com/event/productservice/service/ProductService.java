package com.event.productservice.service;

import com.event.productservice.dto.ProductMapper;
import com.event.productservice.dto.ProductRequest;
import com.event.productservice.dto.ProductResponse;
import com.event.productservice.model.ProductModel;
import com.event.productservice.repository.CategoryRepository;
import com.event.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductResponse createNewProduct(ProductRequest productRequest) {
        return null;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (ProductModel product : products) {
            ProductResponse map = ProductMapper.mapToResponse(product);
            productResponses.add(map);
        }
        return productResponses;
    }
    public ProductResponse updateProduct(ProductRequest productRequest, Integer Id) {
        var retrievedProduct = productRepository.findById(Id).orElseThrow();
         var retrievedCategory = categoryRepository.findById(productRequest.categoryId()).orElseThrow();
        retrievedProduct.setId(productRequest.id());
        retrievedProduct.setName(productRequest.name());
        retrievedProduct.setDescription(productRequest.description());
        retrievedProduct.setPrice(productRequest.price());
        retrievedProduct.setCategory(retrievedCategory);
        retrievedProduct.setImage(productRequest.image());
        var updated = productRepository.save(retrievedProduct);
        return ProductMapper.mapToResponse(updated);
    }

    public boolean deleteProduct(Integer Id) {
        var findProduct = productRepository.findById(Id).orElseThrow();
        productRepository.delete(findProduct);
        return true;
    }

    public ProductResponse getProduct(Integer Id) {
        var retrievedProduct = productRepository.findById(Id).orElseThrow();
        return ProductMapper.mapToResponse(retrievedProduct);
    }
}
