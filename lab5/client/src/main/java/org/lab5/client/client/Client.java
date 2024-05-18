package org.lab5.client.client;

import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.JavaFxFrame;
import org.lab5.client.view.ViewStage;

public class Client {
    private ClientModel model;
    private ClientView view;
    private ClientController clientController;

    public final ClientModel getModel() {
        return model;
    }

    public final ClientController getClientController() {
        return clientController;
    }

    public synchronized void initial() {
        model = new ClientModel();
        view = new ClientView();
        clientController = new ClientController();

        model.setViewStage(ViewStage.CONNECT_FORM);

        view.setModel(model);
        view.setController(clientController);

        clientController.setModel(model);

        new Thread(() -> JavaFxFrame.main(null)).start();
    }
}
