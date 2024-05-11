package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.requests.Request;
import org.lab5.client.view.FormDataContext;
import org.lab5.client.view.ViewStage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void sendRequest(Request request) {
        Socket clientSocket = model.getClientSocket();
        SocketChannel socketChannel = clientSocket.getChannel();

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            oos.flush();
            socketChannel.write(ByteBuffer.wrap(bos.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
