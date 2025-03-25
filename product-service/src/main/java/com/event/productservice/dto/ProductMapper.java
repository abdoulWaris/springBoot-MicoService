package com.event.productservice.dto;

import com.event.productservice.model.Category;
import com.event.productservice.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductModel mapToModel(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }
        return ProductModel.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .price(productRequest.price())
                .category(
                        Category.builder()
                                .id(productRequest.categoryId())
                                .build()
                )
                .description(productRequest.description())
                .build();
    }

    public static ProductResponse mapToResponse(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
       return new ProductResponse(
               productModel.getId(),
               productModel.getPrice(),
               productModel.getName(),
               productModel.getDescription(),
               productModel.getCategory().getName()

       );
    }

    public ProductModel fromRequestToModel(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }
        return mapToModel(productRequest);
    }

    public ProductResponse fromModelToResponse(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
        return mapToResponse(productModel);
    }
}
