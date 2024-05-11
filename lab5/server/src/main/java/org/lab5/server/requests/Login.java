package org.lab5.server.requests;

public class Login extends Request {
    public final String nickname;

    public Login(String nickname) {
        super(RequestType.LOGIN);
        this.nickname = nickname;
    }
}
