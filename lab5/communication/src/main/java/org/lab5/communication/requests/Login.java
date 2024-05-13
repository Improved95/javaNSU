package org.lab5.communication.requests;

public class Login extends Request {
    public final String nickname;
    public final String messageType;

    public Login(String nickname, String messageType) {
        super(RequestType.LOGIN);
        this.nickname = nickname;
        this.messageType = messageType;
    }
}
