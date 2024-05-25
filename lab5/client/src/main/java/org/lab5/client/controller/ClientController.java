package org.lab5.client.controller;

import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;

import org.lab5.client.view.ViewStage;
import org.lab5.communication.communicate.SendReceiveRequest;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.communicate.Sender;
import org.lab5.communication.requests.*;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ClientController {
    private ClientModel model;

    private Selector selector;
    private ClientChannelsHandler clientChannelsHandler;
    private Thread channelsHandlerThread;

    private Sender sender;
    private Thread senderThread;

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void sendMessage(String message) {
        MessageFromClientReq messageFromClientReqRequest = new MessageFromClientReq(message);
        try {
            SendReceiveRequest.sendRequest(messageFromClientReqRequest, model.getClientSocketChannel(), model.getTransferProtocol(), sender);
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void getListOfClients() {
        model.setClientListStatus(ClientListStatus.REQUEST);
        ClientsListRequestReq clientsListRequestReq = new ClientsListRequestReq();
        try {
            SendReceiveRequest.sendRequest(clientsListRequestReq, model.getClientSocketChannel(), model.getTransferProtocol(), sender);
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void connectToServer() {
        try {
            //connect to server
            SocketChannel clientSocketChannel = SocketChannel.open(
                    new InetSocketAddress(model.getServerIP(), model.getServerPort()));
            clientSocketChannel.configureBlocking(false);

            selector = Selector.open();
            clientSocketChannel.register(selector, SelectionKey.OP_READ);

            model.setClientSocketChannel(clientSocketChannel);

            //send transport protocol
            byte byteBuffer[] = new byte[1];
            if (model.getTransferProtocol().equals(TransferProtocol.SERIALIZABLE)) {
                byteBuffer[0] = 10;
            } else if (model.getTransferProtocol().equals(TransferProtocol.XML)) {
                byteBuffer[0] = 20;
            }
            model.getClientSocketChannel().write(ByteBuffer.wrap(byteBuffer));

            //create sender
            sender = new Sender();
            senderThread = new Thread(sender);
            senderThread.start();

            //send login request
            SendReceiveRequest.sendRequest(new LoginReq(model.getNickname()), model.getClientSocketChannel(), model.getTransferProtocol(), sender);
            model.setViewStage(ViewStage.CHAT);

            //create channels handler thread
            clientChannelsHandler = new ClientChannelsHandler(model, this, selector);
            channelsHandlerThread = new Thread(clientChannelsHandler);
            channelsHandlerThread.start();
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            if (model.getClientSocketChannel() != null) {
                model.getClientSocketChannel().close();
                clientChannelsHandler.stopChannelsHandle();
                sender.stopSendData();

                model.getMessagesList().clear();
                model.getNotificationList().clear();

                channelsHandlerThread.interrupt();
                senderThread.interrupt();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
