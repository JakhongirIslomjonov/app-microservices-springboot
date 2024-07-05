package com.example.notification.mappers;

import com.example.clients.notification.NotificationDTO;
import com.example.notification.entity.Notification;
import org.mapstruct.*;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {
    Notification toEntity(NotificationDTO notificationDTO);

    NotificationDTO toDto(Notification notification);


}