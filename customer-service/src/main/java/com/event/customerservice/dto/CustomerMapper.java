package com.event.customerservice.dto;

import com.event.customerservice.model.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static CustomerModel mapToModel(CustomerRequest customerRequest){
        if (customerRequest == null) {
            return null;
        }
        return CustomerModel.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstname())
                .lastName(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
    }

    public static CustomerResponse mapToResponse(CustomerModel customerModel){
        if (customerModel == null) {
            return null;
        }
        return new CustomerResponse(
                customerModel.getId(),
                customerModel.getFirstName(),
                customerModel.getLastName(),
                customerModel.getEmail()
        );
    }

    public CustomerModel mapRequestToModel(CustomerRequest customerRequest){
        return mapToModel(customerRequest);
    }

    public CustomerResponse mapModelToResponse(CustomerModel customerModel){
        return mapToResponse(customerModel);
    }
}
