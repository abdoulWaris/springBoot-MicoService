package com.event.productservice.dto;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        String image,
        BigDecimal price,
        String name,
        String description,
        Integer categoryId
) {
}
