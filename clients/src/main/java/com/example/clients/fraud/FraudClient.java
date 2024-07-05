package com.example.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud")
public interface FraudClient {
    @GetMapping("/api/fraud-check/{customerId}")
    FraudCheckResponse checkFraudster(@PathVariable(value = "customerId", required = false) Integer customerId);
}
