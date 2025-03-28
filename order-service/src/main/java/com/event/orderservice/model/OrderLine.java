package com.event.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;
}
