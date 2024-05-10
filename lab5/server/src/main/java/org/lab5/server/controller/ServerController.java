package org.lab5.server.controller;

import org.lab5.server.model.ServerModel;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {
    private ServerModel serverModel;

    public void setServerModel(ServerModel serverModel) {
        this.serverModel = serverModel;
    }

    public void initialServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverModel.getSocket());
        serverModel.setServerSocket(serverSocket);
    }

    public void stopServer() throws IOException {
        serverModel.getServerSocket().close();
    }

    public void clientRegistration() throws IOException {
        while (true) {
            new Thread(new ClientHandler(serverModel.getServerSocket().accept())).start();
        }
    }
}
