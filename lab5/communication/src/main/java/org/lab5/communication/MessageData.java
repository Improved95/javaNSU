package org.lab5.communication;

import java.io.Serializable;

public class MessageData implements Serializable {
    public final String nickname;
    public final String message;

    public MessageData(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }
}
