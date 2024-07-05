package com.example.clients.notification;

import lombok.Value;

import java.io.Serializable;


@Value
public class NotificationDTO implements Serializable {
    Integer customerId;
    String message;
}