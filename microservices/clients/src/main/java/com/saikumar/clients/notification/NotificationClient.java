package com.saikumar.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("notifications")
public interface NotificationClient {
    @PostMapping (path="api/v1/notifications")
    void sendNotification(NotificationRequest notificationRequest);
}
