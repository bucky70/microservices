package com.saikumar.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;//in real life we will have thirdparty service or your own system that gives this data
    }

}
