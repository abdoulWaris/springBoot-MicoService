package com.event.customerservice.repository;

import com.event.customerservice.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
}
