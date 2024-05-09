package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.view.FormDataContext;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void connectToServer(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.getIP());
        model.setServerSocket(Integer.parseInt(formDataContext.getSocket()));
        model.setNickname(formDataContext.getNickname());


    }
}
