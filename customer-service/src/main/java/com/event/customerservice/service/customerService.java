package com.event.customerservice.service;

import com.event.customerservice.dto.CustomerMapper;
import com.event.customerservice.dto.CustomerRequest;
import com.event.customerservice.dto.CustomerResponse;
import com.event.customerservice.model.CustomerModel;
import com.event.customerservice.repository.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class customerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAllCustomer(){
        List<CustomerModel> customerModelList = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for (CustomerModel customerModel : customerModelList) {
            customerResponseList.add(CustomerMapper.mapToResponse(customerModel));
        }
        return customerResponseList;
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        var customer = customerRepository.save(CustomerMapper.mapToModel(customerRequest));
        return CustomerMapper.mapToResponse(customer);
    }
    public CustomerResponse updateCustomer(CustomerRequest customerRequest,Integer id){
        var foundCustomer = customerRepository.findById(id).orElse(null);
        assert foundCustomer != null;
        foundCustomer.setEmail(customerRequest.email());
        foundCustomer.setFirstName(customerRequest.firstname());
        foundCustomer.setLastName(customerRequest.lastname());
        customerRepository.save(foundCustomer);

        return CustomerMapper.mapToResponse(foundCustomer);
    }
    public void mergeCustomer(CustomerRequest request, CustomerModel customer){
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstName(request.firstname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
    }

    public boolean existCustomer(Integer id){
        return customerRepository.findById(id).isPresent();
    }

    public CustomerResponse getCustomer(Integer id){
        return customerRepository.findById(id)
                .map(customerMapper::mapModelToResponse)
                .orElse(null);
    }
    public boolean deleteCustomer(Integer id){
       var foundCustomer = customerRepository.findById(id).orElse(null);
       if(foundCustomer != null){
           customerRepository.deleteById(id);
           return true;
       }
        return false;
    }
}
