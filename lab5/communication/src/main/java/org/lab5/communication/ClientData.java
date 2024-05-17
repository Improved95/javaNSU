package org.lab5.communication;

import java.io.Serializable;

public class ClientData implements Serializable {
    private String nickname;
    public final TransferProtocol transferProtocol;

    public ClientData(TransferProtocol transferProtocol) {
        this.transferProtocol = transferProtocol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
