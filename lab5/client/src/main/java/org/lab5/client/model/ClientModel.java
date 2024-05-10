package org.lab5.client.model;

import java.net.Socket;

public class ClientModel {
    private String serverIP;
    private int serverSocket;
    private String nickname;

    private Socket clientSocket;

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

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}
