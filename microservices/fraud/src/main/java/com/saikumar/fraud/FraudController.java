package com.saikumar.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-controller")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private FraudCheckService fraudCheckService;

    @GetMapping(path="/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){
        log.info("fraud check for customer id {}", customerID);
        boolean isFraudulent=fraudCheckService.isFraudulentCustomer(customerID);
        return new FraudCheckResponse(isFraudulent);
    }

}
