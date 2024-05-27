package org.lab5.server.server;

import org.lab5.server.controller.ServerController;
import org.lab5.server.controller.ServerRequestHandler;
import org.lab5.server.model.ServerModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

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
        ServerRequestHandler.setController(serverController);

        serverController.initialServer();
        serverController.initialChannelHandler();
        serverController.initialDataSender();

        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            line = scanner.next();
        } while (!line.equals("break"));
        serverController.stopServer();
    }
}
