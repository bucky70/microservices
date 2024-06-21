package com.saikumar.customer;

import com.saikumar.clients.fraud.FraudClient;
import com.saikumar.clients.notification.NotificationClient;
import com.saikumar.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.saikumar.clients.fraud.FraudCheckResponse;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
   // private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerWithRestTemplate(CustomerRegistrationRequest request){
        Customer customer= Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email is valid
        //TODO: check if email is not taken
        customerRepository.saveAndFlush(customer); //save doesnot save data immediately, saveAndFlush saves data instantly
        //TODO: check if fraudster
      /*  FraudCheckResponse fraudCheckResponse=restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-controller/{customerid}", FraudCheckResponse.class,customer.getId());//replce localhost:8081 with FRAUD
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }*/
        //TODO: send notification
    }
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
        FraudCheckResponse fraudCheckResponse=fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo : send notification
        NotificationRequest notificationRequest=new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("hi %s, welcome to amigoscode",customer.getFirstName()));
       notificationClient.sendNotification(notificationRequest);
    }


}
