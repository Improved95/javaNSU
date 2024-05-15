package org.lab5.communication;

import org.lab5.communication.requests.notification.NotificationType;

import java.io.Serializable;

public class NotificationData implements Serializable {
    public final NotificationType notificationType;
    public final String text;

    public NotificationData(NotificationType notificationType, String text) {
        this.notificationType = notificationType;
        this.text = text;
    }
}
