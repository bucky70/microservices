package com.saikumar.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;
    public void register(CustomerRegistrationRequest request){
        Customer customer= Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email is valid
        //TODO: check if email is not taken
        customerRepository.saveAndFlush(customer); //save doesnot save data immediately, saveAndFlush saves data instantly
        //TODO: check if fraudster
        FraudCheckResponse fraudCheckResponse=restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-controller/{customerid}", FraudCheckResponse.class,customer.getId());//replce localhost:8081 with FRAUD
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //TODO: send notification
    }
}
