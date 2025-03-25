package com.event.productservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @NotNull(message = "Product price is required") @DecimalMin("0.1") @Column(nullable = false)
    private BigDecimal price;
    private String image;
    @ManyToOne
    private Category category;
}
