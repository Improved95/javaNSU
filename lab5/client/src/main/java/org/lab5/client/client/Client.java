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
        clientController.setMainWorkflow(this);

        new Thread(() -> JavaFxFrame.main(null)).start();

        synchronized (this) {
            try {
                while (!clientModel.isConnectToServer()) {
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("continue work initial");
    }

    public synchronized void wakeUp() {
        notifyAll();
    }
}
