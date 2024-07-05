package com.example.fraud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fraud_check_history")
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer customerId;

    private Boolean isFraudster;
    @CreatedDate
    private LocalDateTime checkDataTime;

    public FraudCheckHistory(Integer customerId, Boolean isFraudster, LocalDateTime checkDataTime) {
        this.customerId = customerId;
        this.isFraudster = isFraudster;
        this.checkDataTime = checkDataTime;
    }
}