package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.view.FormDataContext;

import java.io.IOException;
import java.net.*;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void connectToServer(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.getIP());
        model.setServerSocket(Integer.parseInt(formDataContext.getSocket()));
        model.setNickname(formDataContext.getNickname());

        try {
            Socket clientSocket = new Socket(model.getServerIP(), model.getServerSocket());
            model.setClientSocket(clientSocket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            model.getClientSocket().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
