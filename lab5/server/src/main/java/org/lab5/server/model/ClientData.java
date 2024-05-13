package org.lab5.server.model;

import org.lab5.communication.TransferProtocol;

public class ClientData {
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
