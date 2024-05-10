package org.lab5.server.model;

import java.net.ServerSocket;

public class ServerModel {
    private int socket;
    private ServerSocket serverSocket;

    public int getSocket() {
        return socket;
    }

    public void setSocket(int socket) {
        this.socket = socket;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
