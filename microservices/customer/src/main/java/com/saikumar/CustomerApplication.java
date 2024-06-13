package com.saikumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.saikumar.clients")
public class CustomerApplication{
    public static void main( String[] args ){
       SpringApplication.run(CustomerApplication.class, args);
    }
}
