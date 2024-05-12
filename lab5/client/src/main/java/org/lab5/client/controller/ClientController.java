package org.lab5.client.controller;

import org.lab5.client.client.Client;
import org.lab5.client.model.ClientModel;
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
//        model.setServerIP(formDataContext.IP);
//        model.setServerSocket(Integer.parseInt(formDataContext.socket));
//        model.setNickname(formDataContext.nickname);

        try {
            SocketChannel clientSocketChannel = SocketChannel.open();
            clientSocketChannel.bind(new InetSocketAddress(model.getServerIP(), model.getServerSocket()));
            clientSocketChannel.configureBlocking(false);
            model.setClientSocketChannel(clientSocketChannel);
            model.setConnectToServer(true);
            model.setViewStage(ViewStage.CHAT);

//            SendReceiveRequest.sendRequest(model.getClientSocket(), new Login("improve", "xml"));
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
