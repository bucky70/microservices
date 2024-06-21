package com.saikumar.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            for(int i=0; i<1_000_000; i++){
                kafkaTemplate.send("amigoscode", new Message("Hello saikumar, you ar reading this from a shell consumer"+i, LocalDateTime.now()));
            }
        };
    }
}
