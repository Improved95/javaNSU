package org.lab5.communication.requests;

import org.lab5.communication.MessageData;

import java.util.List;

public class MessagesListReq extends Request {
    public final List<MessageData> messagesList;

    public MessagesListReq(List<MessageData> messagesList) {
        super(RequestType.MESSAGE_LIST);
        this.messagesList = messagesList;
    }
}
