package org.lab5.server.model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerModel {
    private int socket;
    private ServerSocket serverSocket;
    private Set<Socket> clientSocketSet = new HashSet<>();

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

    public Set<Socket> getClientSocketSet() {
        return clientSocketSet;
    }

    public void setClientSocketSet(Set<Socket> clientSocketList) {
        this.clientSocketSet = clientSocketList;
    }
}
