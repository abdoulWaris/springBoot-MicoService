package com.event.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        BigDecimal price,
        String name,
        String description,
        String categoryName
) {
}
