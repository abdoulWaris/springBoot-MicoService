package com.event.orderservice.repository;

import com.event.orderservice.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
