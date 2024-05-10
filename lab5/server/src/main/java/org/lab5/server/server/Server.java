package org.lab5.server.server;

import org.lab5.server.controller.ServerController;
import org.lab5.server.model.ServerModel;

import java.io.IOException;

public class Server {
    private ServerModel serverModel;
    private ServerController serverController;

    public void initial() {
        serverModel = new ServerModel();
        serverController = new ServerController();

        serverModel.setSocket(65525);

        serverController.setServerModel(serverModel);

        try {
            serverController.initialServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
