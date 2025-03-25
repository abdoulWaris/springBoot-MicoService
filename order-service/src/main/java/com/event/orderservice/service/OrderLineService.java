package com.event.orderservice.service;

import com.event.orderservice.dto.OrderLineRequest;
import com.event.orderservice.model.OrderLine;
import com.event.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest request) {
        var order = mapper.toOrderLine(request);
        return repository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
