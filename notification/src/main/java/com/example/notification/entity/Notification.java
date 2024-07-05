package com.example.notification.entity;

import jakarta.persistence.*;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer customerId;

    private String message;


}