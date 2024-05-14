package org.lab5.communication.requests;

public class MessageReq extends Request {
    public String message;

    public MessageReq(String message) {
        super(RequestType.MESSAGE);
        this.message = message;
    }
}
