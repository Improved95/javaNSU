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

import static java.lang.Thread.sleep;

public class ClientController {
    private ClientModel model;

    private Selector selector;
    private ChannelsHandler channelsHandler;
    private Thread channelsHandlerThread;

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

    public void connectToServer() {
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(
                    new InetSocketAddress(model.getServerIP(), model.getServerPort()));
            clientSocketChannel.configureBlocking(false);

            selector = Selector.open();
            clientSocketChannel.register(selector, SelectionKey.OP_READ);

            model.setClientSocketChannel(clientSocketChannel);

//            channelsHandler = new ChannelsHandler(model, this, selector);
//            channelsHandlerThread = new Thread(channelsHandler);
//            channelsHandlerThread.start();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1);
            if (model.getTransferProtocol().equals(TransferProtocol.SERIALIZABLE)) {
                byteBuffer.put((byte) 10);
                System.out.println("SERIALIZABLE");
            } else if (model.getTransferProtocol().equals(TransferProtocol.XML)) {
                byteBuffer.put((byte) 20);
                System.out.println("XML");
            }
            model.getClientSocketChannel().write(byteBuffer);

//            SendReceiveRequest.sendRequest(model.getClientSocketChannel(), new LoginReq(model.getNickname()));
//            model.setViewStage(ViewStage.CHAT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            if (model.getClientSocketChannel() != null) {
                model.getClientSocketChannel().close();
//                channelsHandler.stopChannelsHandle();
//                channelsHandlerThread.interrupt();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
