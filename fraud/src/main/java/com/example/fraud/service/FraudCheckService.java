package com.example.fraud.service;

import com.example.fraud.entity.FraudCheckHistory;
import com.example.fraud.repo.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public Boolean isFraudster(Integer customerId) {
        fraudCheckHistoryRepository.save(new FraudCheckHistory(
                customerId, false, LocalDateTime.now()
        ));
        return false;
    }
}
