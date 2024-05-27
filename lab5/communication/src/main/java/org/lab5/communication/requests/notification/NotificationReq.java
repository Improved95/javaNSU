package org.lab5.communication.requests.notification;

import org.lab5.communication.NotificationData;
import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.RequestType;

public class NotificationReq extends Request {
    public final NotificationData notificationData;

    public NotificationReq(NotificationData notificationData) {
        super(RequestType.NOTIFICATION);
        this.notificationData = notificationData;
    }
}
