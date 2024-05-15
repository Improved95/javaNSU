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
    private boolean continueChannelsHandler = true;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void sendMessage(String message) {
        MessageFromClientReq messageFromClientReqRequest = new MessageFromClientReq(message);
        SendReceiveRequest.sendRequest(model.getClientSocketChannel(), messageFromClientReqRequest);
    }

    public void getListOfClients() {
        model.setClientListStatus(ClientListStatus.REQUEST);
        ClientsListRequestReq clientsListRequestReq = new ClientsListRequestReq();
        SendReceiveRequest.sendRequest(model.getClientSocketChannel(), clientsListRequestReq);
    }

    public void channelsHandler() throws IOException, ClassNotFoundException {
        while (continueChannelsHandler) {
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

    public void connectToServer() {
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

            SendReceiveRequest.sendRequest(model.getClientSocketChannel(), new LoginReq(model.getNickname()));
//            model.setConnectToServer(true);
        } catch (IOException ex) {
//            model.setTryToConnectToServer(false);
//            model.setConnectToServer(false);
            ex.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            if (model.getClientSocketChannel() != null) {
                continueChannelsHandler = false;
                model.getClientSocketChannel().close();
            }
            continueChannelsHandler = false;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
