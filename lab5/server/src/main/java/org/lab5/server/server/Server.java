package org.lab5.server.server;

import org.lab5.server.controller.ServerController;
import org.lab5.server.model.ServerModel;

import java.io.IOException;
import java.io.InputStream;

public class Server {
    private ServerModel serverModel;
    private ServerController serverController;

    public void initial() {
        serverModel = new ServerModel();
        serverController = new ServerController();

        try (InputStream inputStream = getClass().getResourceAsStream("config")) {
            serverModel.setServerProperty(ConfigParser.parse(inputStream));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        serverController.setServerModel(serverModel);

        try {
            serverController.initialServer();
            serverController.channelsHandler();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
