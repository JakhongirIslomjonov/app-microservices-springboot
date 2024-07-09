package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients(basePackages = "com.example.clients")
@SpringBootApplication(scanBasePackages = {"com.example.customer", "com.example.amqp"})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

 /*   @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
}
