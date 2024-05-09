package org.lab5.client.model;

public class ClientModel {
    private String serverIP;
    private int serverSocket;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public int getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(int serverSocket) {
        this.serverSocket = serverSocket;
    }
}
