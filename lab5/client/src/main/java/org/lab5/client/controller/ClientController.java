package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.requests.Login;
import org.lab5.client.view.FormDataContext;
import org.lab5.client.view.ViewStage;

import java.io.IOException;
import java.net.*;
import java.nio.channels.SocketChannel;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void connectToServer(FormDataContext formDataContext) {
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(new InetSocketAddress(model.getServerIP(), model.getServerSocket()));
            clientSocketChannel.configureBlocking(false);

            model.setClientSocketChannel(clientSocketChannel);
            model.setViewStage(ViewStage.CHAT);

            System.out.println(model.getClientSocketChannel().isConnected());
            SendReceiveRequest.sendRequest(model.getClientSocketChannel(), new Login("improve", "xml"));
        } catch (IOException ex) {
            model.setConnectToServer(false);
            ex.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            if (model.getClientSocketChannel() != null) {
                model.getClientSocketChannel().close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
