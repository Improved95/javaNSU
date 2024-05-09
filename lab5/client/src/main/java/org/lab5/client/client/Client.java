package org.lab5.client.client;

import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;

public class Client {
    private static ClientModel clientModel;
    private static ClientController clientController;

    public static void initial() {
        clientModel = new ClientModel();
        clientController = new ClientController();


    }
}
