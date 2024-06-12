package com.saikumar.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void register(CustomerRegistrationRequest request){
        Customer customer= Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email is valid
        //TODO: check if email is not taken
        //TODO: store customer in db
        customerRepository.save(customer);
    }
}
