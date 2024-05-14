package org.lab5.communication.requests.notification;

import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.RequestType;

public class NotificationReq extends Request {
    public final NotificationType notificationType;
    public final String clientNickname;

    public NotificationReq(NotificationType notificationType, String clientNickname) {
        super(RequestType.NOTIFICATION);
        this.notificationType = notificationType;
        this.clientNickname = clientNickname;
    }
}
