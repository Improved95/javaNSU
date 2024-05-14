package org.lab5.communication.requests;

public class MessageFromClientReq extends Request {
    public final String message;

    public MessageFromClientReq(String message) {
        super(RequestType.MESSAGE_FROM_CLIENT);
        this.message = message;
    }
}
