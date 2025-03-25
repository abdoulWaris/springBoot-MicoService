package com.event.customerservice.controller;

import com.event.customerservice.dto.CustomerRequest;
import com.event.customerservice.dto.CustomerResponse;
import com.event.customerservice.service.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final customerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("customer-id") String customerId,
                                                           @RequestBody CustomerRequest customerRequest)
    {
        return new ResponseEntity<>(customerService.updateCustomer(customerRequest,
                Integer.valueOf(customerId)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer-id") String customerId){
        var deletedCustomer = customerService.deleteCustomer(Integer.valueOf(customerId));
        if (!deletedCustomer){
            return ResponseEntity.accepted().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customerId") String customerId){
        var foundCustomer = customerService.getCustomer(Integer.valueOf(customerId));
        if (foundCustomer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCustomer,HttpStatus.OK);
        }
}
