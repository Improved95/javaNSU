package org.lab5.communication;

import java.io.Serializable;
import java.nio.channels.SocketChannel;

public class ClientData implements Serializable {
    private String nickname;
    public final SocketChannel socketChannel;
    public final TransferProtocol transferProtocol;

    public ClientData(SocketChannel socketChannel, TransferProtocol transferProtocol) {
        this.socketChannel = socketChannel;
        this.transferProtocol = transferProtocol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
