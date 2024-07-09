package com.example.notification.rabbitmq;

import com.example.clients.notification.NotificationDTO;
import com.example.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationService notificationService;

    @RabbitListener(queues = "myqueue")
    public void consumer(NotificationDTO notificationDTO) {
        notificationService.register(notificationDTO);
    }
}

