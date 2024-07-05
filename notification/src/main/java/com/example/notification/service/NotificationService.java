package com.example.notification.service;

import com.example.clients.notification.NotificationDTO;
import com.example.notification.entity.Notification;
import com.example.notification.mappers.NotificationMapper;
import com.example.notification.repo.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public HttpEntity<?> register(NotificationDTO notificationDTO) {
        Notification notification = notificationMapper.toEntity(notificationDTO);


        notificationRepository.save(notification);

        return ResponseEntity.ok(notification);
    }
}
