package org.lab5.server.controller;

import org.lab5.communication.*;
import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.lab5.server.model.ClientData;
import org.lab5.server.model.ServerModel;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.stream.Collectors;

public class ServerController {
    private ServerModel model;

    private Selector selector;
    private ServerChannelsHandler channelsHandler;
    private Thread channelsHandlerThread;

    public void setServerModel(ServerModel serverModel) {
        this.model = serverModel;
    }

    public void registeringNewClient(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel clientSocketChannel = serverSocket.accept();

        byte[] buffer = new byte[1];
        clientSocketChannel.read(ByteBuffer.wrap(buffer));

        System.out.println(buffer[0]);

        ClientData clientData = null;
        switch (buffer[0]) {
            case 10 -> clientData = new ClientData(TransferProtocol.SERIALIZABLE);
            case 20 -> clientData = new ClientData(TransferProtocol.XML);
        }
        model.getClientTable().put(clientSocketChannel, clientData);

        clientSocketChannel.configureBlocking(false);
        clientSocketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void loginNewClient(SocketChannel socketChannel, String nickname) {
        model.getClientTable().get(socketChannel).setNickname(nickname);

        List<MessageData> messagesList = model.getMessageList();
        MessagesListReq messagesListReq = new MessagesListReq(messagesList);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        try {
            SendReceiveRequest.sendRequest(messagesListReq, socketChannel, transferProtocol);
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }

        NotificationReq notificationReq = new NotificationReq(
                new NotificationData(NotificationType.CONNECT, nickname));
        try {
            SendReceiveRequest.broadCast(notificationReq, getClientsListForBroadCast(socketChannel));
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void receiveMessageAndBroadcastToEveryone(MessageFromClientReq messageFromClientReq, SocketChannel socketChannel) {
        String clientNickname = model.getClientTable().get(socketChannel).getNickname();
        MessageData messageData = new MessageData(clientNickname, messageFromClientReq.message);
        model.getMessageList().add(messageData);

        MessageFromServerReq messageFromServerReq = new MessageFromServerReq(messageData);
        try {
            SendReceiveRequest.broadCast(messageFromServerReq, getClientsListForBroadCast(null));
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void sendClientList(SocketChannel socketChannel) {
        List<ClientDataForReq> clientDataForReqList = model.getClientTable().entrySet()
                .stream()
                .map(entry -> new ClientDataForReq(entry.getValue().getNickname()))
                .collect(Collectors.toList());

        ClientsListReceiveReq clientsListReceiveReqRequest = new ClientsListReceiveReq(clientDataForReqList);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        try {
            SendReceiveRequest.sendRequest(clientsListReceiveReqRequest, socketChannel, transferProtocol);
        } catch (IOException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteClient(SocketChannel socketChannel) throws IOException, TransformerException {
        String nickNameRemovedClient = model.getClientTable().get(socketChannel).getNickname();
        model.getClientTable().remove(socketChannel);
        socketChannel.close();

        NotificationData notificationData = new NotificationData(NotificationType.DISCONNECT, nickNameRemovedClient);
        NotificationReq notificationReq = new NotificationReq(notificationData);

        SendReceiveRequest.broadCast(notificationReq, getClientsListForBroadCast(null));
    }

    private List<Map.Entry<SocketChannel, TransferProtocol>> getClientsListForBroadCast(SocketChannel exceptionSocketChannel) {
        return model.getClientTable().entrySet()
                .stream()
                .filter(entry -> {
                    if (exceptionSocketChannel != null) {
                        return !entry.getKey().equals(exceptionSocketChannel);
                    }
                    return true;
                })
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().transferProtocol))
                .collect(Collectors.toList());
    }

    public void initialServer() {
        try {
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", model.getServerPort()));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            model.setServerSocketChannel(serverSocketChannel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initialChannelHandler() {
        channelsHandler = new ServerChannelsHandler(model, this, selector);
        channelsHandlerThread = new Thread(channelsHandler);
        channelsHandlerThread.start();
    }

    public void stopServer() {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        try {
            for (SelectionKey selectionKey : selectionKeys) {
                selectionKey.channel().close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (channelsHandler != null) {
            channelsHandler.stopChannelsHandle();
            channelsHandlerThread.interrupt();
        }
    }
}
