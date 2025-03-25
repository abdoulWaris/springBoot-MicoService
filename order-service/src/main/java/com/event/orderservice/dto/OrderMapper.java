package com.event.orderservice.dto;

import com.event.orderservice.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public  Order mapToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.id())
                .reference(orderRequest.reference())
                .customerId(orderRequest.customerId())
                .totalAmount(orderRequest.amount())
                .orderStatus(orderRequest.status())
                .build();
    }

    public  OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getOrderStatus(),
                order.getCustomerId()
        );
    }
}
