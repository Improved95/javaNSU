package org.lab5.server.model;

public class ClientData {
    private String nickname;

    public ClientData(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
