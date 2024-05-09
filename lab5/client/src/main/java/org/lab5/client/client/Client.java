package org.lab5.client.client;

import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.JavaFxFrame;

public class Client {
    private ClientModel clientModel;
    private ClientView clientView;
    private ClientController clientController;

    public void initial() {
        clientModel = new ClientModel();
        clientView = new ClientView();
        clientController = new ClientController();

        clientView.setClientController(clientController);
        clientController.setModel(clientModel);

        JavaFxFrame.main(null);
    }
}
