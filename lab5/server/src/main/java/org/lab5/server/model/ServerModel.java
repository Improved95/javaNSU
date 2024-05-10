package org.lab5.server.model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerModel {
    private int socket;
    private ServerSocket serverSocket;
    private Map<Socket, ClientData> clientSocketSet = new HashMap();

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

    public Map<Socket, ClientData> getClientSocketSet() {
        return clientSocketSet;
    }
}
