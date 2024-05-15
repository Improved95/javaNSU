package org.lab5.client.view;

import org.lab5.communication.TransferProtocol;

public class ConnectFormDataContext {
    public final String IP;
    public final String socket;
    public final String nickname;
    public final TransferProtocol transferProtocol;

    public ConnectFormDataContext(String IP, String socket, String nickname, TransferProtocol transferProtocol) {
        this.IP = IP;
        this.socket = socket;
        this.nickname = nickname;
        this.transferProtocol = transferProtocol;
    }
}
