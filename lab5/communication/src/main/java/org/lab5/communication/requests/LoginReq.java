package org.lab5.communication.requests;

public class LoginReq extends Request {
    public final String nickname;

    public LoginReq(String nickname) {
        super(RequestType.LOGIN);
        this.nickname = nickname;
    }
}
