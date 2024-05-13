package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;

import org.lab5.client.view.ViewStage;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.requests.Login;
import org.lab5.communication.requests.Message;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientController {
    private ClientModel model;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void sendMessage(String message) {
        Message messageRequest = new Message(message);
        SendReceiveRequest.sendRequest(model.getClientSocketChannel(), messageRequest);
    }

    public int connectToServer() {
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(
                    new InetSocketAddress(model.getServerIP(), model.getServerPort()));
            clientSocketChannel.configureBlocking(false);

            model.setClientSocketChannel(clientSocketChannel);
            model.setViewStage(ViewStage.CHAT);

            ByteBuffer byteBuffer = ByteBuffer.allocate(1);
            if (model.getTransferProtocol() == TransferProtocol.SERIALIZABLE) {
                byteBuffer.put((byte) 0);
            } else {
                byteBuffer.put((byte) 1);
            }
            model.getClientSocketChannel().write(byteBuffer);

            SendReceiveRequest.sendRequest(model.getClientSocketChannel(), new Login("improve"));
            return 0;
        } catch (IOException ex) {
            model.setTryToConnectToServer(false);
            ex.printStackTrace();
            return 1;
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
