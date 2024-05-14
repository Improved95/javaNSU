package org.lab5.client.controller;

import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;

import org.lab5.client.view.ViewStage;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.requests.*;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientController {
    private ClientModel model;

    private Selector selector;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void sendMessage(String message) {
        Message messageRequest = new Message(message);
        SendReceiveRequest.sendRequest(model.getClientSocketChannel(), messageRequest);
    }

    public void getListOfClients() {
        model.setClientListStatus(ClientListStatus.REQUEST);
        ClientsListRequest clientsListRequest = new ClientsListRequest();
        SendReceiveRequest.sendRequest(model.getClientSocketChannel(), clientsListRequest);
    }

    public void channelsHandler() throws IOException, ClassNotFoundException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeySet.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isReadable()) {
                    Request request = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel());
                    ClientRequestHandler.handle(request, model);
                }

                selectionKeysIterator.remove();
            }
        }
    }

    public int connectToServer() {
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(
                    new InetSocketAddress(model.getServerIP(), model.getServerPort()));
            clientSocketChannel.configureBlocking(false);

            selector = Selector.open();
            clientSocketChannel.register(selector, SelectionKey.OP_READ);

            model.setClientSocketChannel(clientSocketChannel);
            model.setViewStage(ViewStage.CHAT);

            ByteBuffer byteBuffer = ByteBuffer.allocate(1);
            if (model.getTransferProtocol() == TransferProtocol.SERIALIZABLE) {
                byteBuffer.put((byte) 0);
            } else {
                byteBuffer.put((byte) 1);
            }
            model.getClientSocketChannel().write(byteBuffer);

            SendReceiveRequest.sendRequest(model.getClientSocketChannel(), new Login(model.getNickname()));
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
