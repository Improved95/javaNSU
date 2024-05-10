package org.lab5.client.controller;

import org.lab5.client.client.Client;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.FormDataContext;
import org.lab5.client.view.ViewStage;

import java.io.IOException;
import java.net.*;

public class ClientController {
    private ClientModel model;
    private Client client;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void setMainWorkflow(Client client) {
        this.client = client;
    }

    public boolean connectToServer(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.IP);
        model.setServerSocket(Integer.parseInt(formDataContext.socket));
        model.setNickname(formDataContext.nickname);

        try {
            Socket clientSocket = new Socket(model.getServerIP(), model.getServerSocket());
            model.setClientSocket(clientSocket);
        } catch (IOException ex) {
            ex.printStackTrace();
            model.setConnectToServer(false);
            return false;
        }

        client.wakeUp();
        model.setViewStage(ViewStage.CHAT);
        model.setConnectToServer(true);
        return true;
    }

    public void stopConnection() {
        try {
            if (model.getClientSocket() != null) {
                model.getClientSocket().close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
