package com.example.fraud.controller;

import com.example.clients.fraud.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-check")
@RequiredArgsConstructor
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;


    @GetMapping("{customerId}")
    public FraudCheckResponse checkFraudster(@PathVariable Integer customerId) {
        Boolean isFraudster = fraudCheckService.isFraudster(customerId);
        return new FraudCheckResponse(isFraudster);
    }
}
