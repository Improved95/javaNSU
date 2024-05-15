package org.lab5.communication;

import org.lab5.communication.requests.notification.NotificationType;

public class NotificationData {
    public final NotificationType notificationType;
    public final String text;

    public NotificationData(NotificationType notificationType, String text) {
        this.notificationType = notificationType;
        this.text = text;
    }
}
