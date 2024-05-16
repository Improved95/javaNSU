package org.lab5.server.controller;

import org.lab5.communication.*;
import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.lab5.server.model.ServerModel;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.*;

public class ServerController {
    private ServerModel model;

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public void setServerModel(ServerModel serverModel) {
        this.model = serverModel;
    }

    public void initialServer() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", model.getServerPort()));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void channelsHandler() throws IOException, ClassNotFoundException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeys.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isAcceptable()) {
                    registeringNewClient(selector, serverSocketChannel);
                }

                if (selectionKey.isReadable()) {
                    TransferProtocol transferProtocol = model.getClientTable().get(selectionKey.channel()).transferProtocol;
                    Request request = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel(), transferProtocol);
                    if (request == null) {
                        deleteClient((SocketChannel) selectionKey.channel());
                    } else {
                        ServerRequestHandler.handle(request, (SocketChannel) selectionKey.channel());
                    }
                }

                selectionKeysIterator.remove();
            }
        }
    }

    private void registeringNewClient(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel clientSocketChannel = serverSocket.accept();
        clientSocketChannel.configureBlocking(false);
        clientSocketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void loginNewClient(SocketChannel socketChannel, String nickname) {
        model.getClientTable().get(socketChannel).setNickname(nickname);

        List<MessageData> messagesList = model.getMessageList();
        MessagesListReq messagesListReq = new MessagesListReq(messagesList);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        SendReceiveRequest.sendRequest(socketChannel, messagesListReq, transferProtocol);

        Set<SocketChannel> socketChannelSet = new HashSet<>(model.getClientTable().keySet());
        socketChannelSet.remove(socketChannel);
        NotificationData notificationData = new NotificationData(NotificationType.CONNECT, nickname);
        NotificationReq notificationReq = new NotificationReq(notificationData);
        SendReceiveRequest.broadCast(socketChannelSet, notificationReq);
    }

    public void setClientTransportProtocol(TransportProtocolReq transportProtocolReq, SocketChannel socketChannel) {
        ClientData clientData;
        if (transportProtocolReq.transportProtocolByte == (byte)10) {
            clientData = new ClientData(TransferProtocol.SERIALIZABLE);
        } else {
            clientData = new ClientData(TransferProtocol.XML);
        }
        model.getClientTable().put(socketChannel, clientData);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        SendReceiveRequest.sendRequest(socketChannel, new TransportProtocolReq((byte) 0), transferProtocol);
    }

    public void receiveMessageAndBroadcastToAnywhere(MessageFromClientReq messageFromClientReq, SocketChannel socketChannel) {
        String clientNickname = model.getClientTable().get(socketChannel).getNickname();
        MessageData messageData = new MessageData(clientNickname, messageFromClientReq.message);
        model.getMessageList().add(messageData);

        Set<SocketChannel> socketChannelSet = model.getClientTable().keySet();
        MessageFromServerReq messageFromServerReq = new MessageFromServerReq(messageData);

        SendReceiveRequest.broadCast(socketChannelSet, messageFromServerReq);
    }

    public void sendClientList(SocketChannel socketChannel) {
        Map<SocketChannel, ClientData> clientTable = model.getClientTable();
        List<ClientData> clientDataList = new ArrayList<>(clientTable.values());
        ClientsListReceiveReq clientsListReceiveReqRequest = new ClientsListReceiveReq(clientDataList);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        SendReceiveRequest.sendRequest(socketChannel, clientsListReceiveReqRequest, transferProtocol);
    }

    private void deleteClient(SocketChannel socketChannel) throws IOException {
        String nickNameRemovedClient = model.getClientTable().get(socketChannel).getNickname();
        model.getClientTable().remove(socketChannel);
        socketChannel.close();

        Set<SocketChannel> socketChannelSet = model.getClientTable().keySet();
        NotificationData notificationData = new NotificationData(NotificationType.DISCONNECT, nickNameRemovedClient);
        NotificationReq notificationReq = new NotificationReq(notificationData);

        SendReceiveRequest.broadCast(socketChannelSet, notificationReq);
    }
}
