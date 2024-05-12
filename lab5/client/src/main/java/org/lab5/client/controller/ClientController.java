package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.view.FormDataContext;
import org.lab5.client.view.ViewStage;
import java.io.IOException;
import java.net.*;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void connectToServer(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.IP);
        model.setServerSocket(Integer.parseInt(formDataContext.socket));
        model.setNickname(formDataContext.nickname);

        try {
            Socket clientSocket = new Socket(model.getServerIP(), model.getServerSocket());
            model.setClientSocket(clientSocket);
            model.setConnectToServer(true);
            model.setViewStage(ViewStage.CHAT);


//            SendReceiveRequest.sendRequest(model.getClientSocket(), new Login("improve", "serialization"));
        } catch (IOException ex) {
            model.setConnectToServer(false);
            ex.printStackTrace();
        }
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
