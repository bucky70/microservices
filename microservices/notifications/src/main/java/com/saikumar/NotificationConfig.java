package com.saikumar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    public String getInternalExchange() {
        return internalExchange;
    }

    public void setInternalExchange(String internalExchange) {
        this.internalExchange = internalExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public void setNotificationQueue(String notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }

    public void setInternalNotificationRoutingKey(String internalNotificationRoutingKey) {
        this.internalNotificationRoutingKey = internalNotificationRoutingKey;
    }
}
