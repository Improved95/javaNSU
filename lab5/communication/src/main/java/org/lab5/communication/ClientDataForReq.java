package org.lab5.communication;

import java.io.Serializable;

public class ClientDataForReq implements Serializable {
    public final String nickname;

    public ClientDataForReq(String nickname) {
        this.nickname = nickname;
    }
}
