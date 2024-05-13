package org.lab5.communication.requests;

import org.lab5.communication.MessageType;

public class Login extends Request {
    public final String nickname;
    public final MessageType messageType;

    public Login(String nickname, MessageType messageType) {
        super(RequestType.LOGIN);
        this.nickname = nickname;
        this.messageType = messageType;
    }
}
