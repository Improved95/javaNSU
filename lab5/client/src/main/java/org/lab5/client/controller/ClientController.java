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

    public int connectToServer(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.getIP());
        model.setServerSocket(Integer.parseInt(formDataContext.getSocket()));
        model.setNickname(formDataContext.getNickname());

        try {
            Socket clientSocket = new Socket(model.getServerIP(), model.getServerSocket());
            model.setClientSocket(clientSocket);
            System.out.println("connect");
        } catch (IOException ex) {
            ex.printStackTrace();
            return -1;
        }
        return 0;
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
