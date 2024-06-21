package com.saikumar.kafkaexample.config;

import com.saikumar.kafkaexample.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "amigoscode", groupId = "my-group")//, containerFactory="message-factory"
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
