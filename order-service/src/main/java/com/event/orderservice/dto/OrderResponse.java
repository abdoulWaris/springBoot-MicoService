package com.event.orderservice.dto;

import com.event.orderservice.common.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        OrderStatus status,
        String customerId

) {
}
