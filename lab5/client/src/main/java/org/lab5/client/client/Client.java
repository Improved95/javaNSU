package org.lab5.client.client;

import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.JavaFxFrame;
import org.lab5.client.view.ViewStage;

public class Client {
    private ClientModel clientModel;
    private ClientView clientView;
    private ClientController clientController;

    private boolean stopTryConnect = false;

    public final ClientModel getClientModel() {
        return clientModel;
    }

    public final ClientController getClientController() {
        return clientController;
    }

    public void setStopTryConnect(boolean stopTryConnect) {
        this.stopTryConnect = stopTryConnect;
    }

    public synchronized void initial() {
        clientModel = new ClientModel();
        clientView = new ClientView();
        clientController = new ClientController();

        clientModel.setViewStage(ViewStage.CONNECT_FORM);

        clientView.setModel(clientModel);
        clientView.setController(clientController);
        clientView.setClientWorkflow(this);

        clientController.setModel(clientModel);

        new Thread(() -> JavaFxFrame.main(null)).start();

        do {
            while (!clientModel.isTryToConnectToServer() && !stopTryConnect) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (clientController.connectToServer() == 0 ? false : true && !stopTryConnect);
    }

    public synchronized void wakeUp() {
        notifyAll();
    }
}
