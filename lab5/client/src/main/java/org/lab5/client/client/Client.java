package org.lab5.client.client;

import javafx.application.Platform;
import org.lab5.client.controller.ClientController;
import org.lab5.client.controller.SendMessage;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.JavaFxFrame;

import java.io.IOException;

import static java.lang.Thread.sleep;

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

        new Thread(() -> JavaFxFrame.main(null)).start();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SendMessage sendMessage = new SendMessage();
        try {
            sendMessage.setClientModel(clientModel);
            sendMessage.sendReceiveMes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
