package com.event.productservice.repository;

import com.event.productservice.model.Category;
import com.event.productservice.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    ProductModel findByCategory(Category category);
}
