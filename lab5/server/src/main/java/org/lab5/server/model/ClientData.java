package org.lab5.server.model;

import org.lab5.communication.MessageType;

public class ClientData {
    public final String nickname;
    public final MessageType messageType;

    public ClientData(String nickname, MessageType messageType) {
        this.nickname = nickname;
        this.messageType = messageType;
    }
}
