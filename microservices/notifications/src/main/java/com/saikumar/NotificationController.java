package com.saikumar;

import com.saikumar.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("new customer Registration {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
