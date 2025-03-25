package com.event.customerservice.dto;

public record CustomerResponse(
        Integer id,
        String firstname,
        String lastname,
        String email
){
}
