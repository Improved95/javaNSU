package org.lab5.server.model;

import org.lab5.communication.TransferProtocol;

import java.nio.ByteBuffer;

public class ClientData {
    public final String nickname;
    public final TransferProtocol transferProtocol;
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

    public ClientData(String nickname, TransferProtocol transferProtocol) {
        this.nickname = nickname;
        this.transferProtocol = transferProtocol;
    }

    public ByteBuffer getSendBuffer() {
        return sendBuffer;
    }

    public ByteBuffer getReceiveBuffer() {
        return receiveBuffer;
    }
}
