package org.lab5.server.controller;

import org.lab5.communication.*;
import org.lab5.communication.communicate.SendReceiveRequest;
import org.lab5.communication.communicate.Sender;
import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.lab5.server.model.ClientData;
import org.lab5.server.model.ServerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.stream.Collectors;

public class ServerController {
    private final Logger logger = LoggerFactory.getLogger(ServerController.class);

    private ServerModel model;

    private Selector selector;
    private ServerChannelsHandler channelsHandler;
    private Thread channelsHandlerThread;

    private Sender sender;
    private Thread senderThread;

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

        logger.info("registered new client {}", clientSocketChannel);
    }

    public void loginNewClient(SocketChannel socketChannel, String nickname) {
        model.getClientTable().get(socketChannel).setNickname(nickname);

        List<MessageData> messagesList = model.getMessageList();
        MessagesListReq messagesListReq = new MessagesListReq(messagesList);

        TransferProtocol transferProtocol = model.getClientTable().get(socketChannel).transferProtocol;
        try {
            SendReceiveRequest.sendRequest(messagesListReq, socketChannel, transferProtocol, sender);
            logger.info("send all messages in chat for {} by {}", socketChannel, transferProtocol);
        } catch (IOException | TransformerException ex) {
            logger.error("exception on send all messages in chat for new client: ", ex);
        }

        NotificationReq notificationReq = new NotificationReq(
                new NotificationData(NotificationType.CONNECT, nickname));
        try {
            SendReceiveRequest.broadCast(notificationReq, getClientsListForBroadCast(socketChannel), sender);
        } catch (IOException | TransformerException ex) {
            logger.error("exception on notify all clients about new client: ", ex);
        }

        logger.info("logging new client");
    }

    public void receiveMessageAndBroadcastToEveryone(MessageFromClientReq messageFromClientReq, SocketChannel socketChannel) {
        String clientNickname = model.getClientTable().get(socketChannel).getNickname();
        MessageData messageData = new MessageData(clientNickname, messageFromClientReq.message);
        model.getMessageList().add(messageData);

        MessageFromServerReq messageFromServerReq = new MessageFromServerReq(messageData);
        try {
            SendReceiveRequest.broadCast(messageFromServerReq, getClientsListForBroadCast(null), sender);
            logger.info("send new message to all clients");
        } catch (IOException | TransformerException ex) {
            logger.error("exception on send new message {} to all clients ", messageFromServerReq, ex);
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
            SendReceiveRequest.sendRequest(clientsListReceiveReqRequest, socketChannel, transferProtocol, sender);
            logger.info("send clientsList to {} by {}", socketChannel, transferProtocol);
        } catch (IOException | TransformerException ex) {
            logger.error("exception on send clientsList {} to {} by {}", clientsListReceiveReqRequest, socketChannel, transferProtocol, ex);
        }
    }

    public void deleteClient(SocketChannel socketChannel) throws IOException, TransformerException {
        String nickNameRemovedClient = model.getClientTable().get(socketChannel).getNickname();
        model.getClientTable().remove(socketChannel);
        socketChannel.close();

        NotificationData notificationData = new NotificationData(NotificationType.DISCONNECT, nickNameRemovedClient);
        NotificationReq notificationReq = new NotificationReq(notificationData);

        SendReceiveRequest.broadCast(notificationReq, getClientsListForBroadCast(null), sender);
        logger.info("client {} disconnected", socketChannel);
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
            logger.info("server initialized");
        } catch (IOException ex) {
            logger.error("server cannot initialize ", ex);
            throw new RuntimeException();
        }
    }

    public void initialChannelHandler() {
        channelsHandler = new ServerChannelsHandler(model, this, selector);
        channelsHandlerThread = new Thread(channelsHandler);
        channelsHandlerThread.start();
    }

    public void initialDataSender() {
        sender = new Sender();
        senderThread = new Thread(sender);
        senderThread.start();
    }

    public void stopServer() {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        try {
            for (SelectionKey selectionKey : selectionKeys) {
                selectionKey.channel().close();
            }
        } catch (IOException ex) {
            logger.error("exception on stopped server ", ex);
        }

        if (channelsHandler != null) {
            channelsHandler.stopChannelsHandle();
            channelsHandlerThread.interrupt();
        }
        if (sender != null) {
            sender.stopSendData();
            senderThread.interrupt();
        }
        logger.info("server stopped");
    }
}
