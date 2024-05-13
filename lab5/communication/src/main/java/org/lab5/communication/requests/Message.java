package org.lab5.communication.requests;

public class Message extends Request {
    public String message;

    public Message(String message) {
        super(RequestType.MESSAGE);
        this.message = message;
    }
}
