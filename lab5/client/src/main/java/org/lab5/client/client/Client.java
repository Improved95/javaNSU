package org.lab5.client.client;

import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.ViewStage;

public class Client {
    private ClientModel clientModel;
    private ClientView clientView;
    private ClientController clientController;

    public final ClientModel getClientModel() {
        return clientModel;
    }

    public final ClientController getClientController() {
        return clientController;
    }

    public void initial() {
        clientModel = new ClientModel();
        clientView = new ClientView();
        clientController = new ClientController();

        clientModel.setViewStage(ViewStage.CONNECT_FORM);

        clientView.setClientModel(clientModel);
        clientView.setClientController(clientController);

        clientController.setModel(clientModel);

//        new Thread(() -> JavaFxFrame.main(null)).start();

    }
}
