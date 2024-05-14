package org.lab5.communication.requests;

import org.lab5.communication.MessageData;

import java.util.List;

public class MessagesList extends Request {
    public final List<MessageData> messagesList;

    public MessagesList(List<MessageData> messagesList) {
        super(RequestType.MESSAGE_LIST);
        this.messagesList = messagesList;
    }
}
