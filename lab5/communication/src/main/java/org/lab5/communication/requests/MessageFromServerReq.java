package org.lab5.communication.requests;

import org.lab5.communication.MessageData;

public class MessageFromServerReq extends Request {
    public final MessageData messageData;

    public MessageFromServerReq(MessageData messageData) {
        super(RequestType.MESSAGE_FROM_SERVER);
        this.messageData = messageData;
    }
}
