package org.lab5.server.controller;

import org.lab5.communication.ClientData;
import org.lab5.communication.NotificationData;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.requests.*;
import org.lab5.communication.MessageData;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.lab5.server.model.ServerModel;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServerRequestHandler {
    public static void handle(Request request, SocketChannel socketChannel, ServerModel model) {
        switch (request.requestType) {
            case LOGIN -> handleLogin(request, socketChannel, model);
            case MESSAGE_FROM_CLIENT -> handleMessage(request, socketChannel, model);
            case CLIENTS_LIST_REQUEST -> handleListParticipantsRequest(socketChannel, model);
        }
    }

    private static void handleLogin(Request request, SocketChannel socketChannel, ServerModel model) {
        LoginReq loginReqRequest = (LoginReq) request;
        model.getClientTable().get(socketChannel).setNickname(loginReqRequest.nickname);

        /*Set<SocketChannel> socketChannelSet = model.getClientTable().keySet();
        socketChannelSet.remove(socketChannel);
        String nickNameClientConnected = model.getClientTable().get(socketChannel).getNickname();
        NotificationData notificationData = new NotificationData(NotificationType.CONNECT, nickNameClientConnected);
        NotificationReq notificationReq = new NotificationReq(notificationData);
        SendReceiveRequest.broadCast(socketChannelSet, notificationReq);*/
    }

    private static void handleMessage(Request request, SocketChannel socketChannel, ServerModel model) {
        String clientNickname = model.getClientTable().get(socketChannel).getNickname();
        MessageFromClientReq messageFromClientReqRequest = (MessageFromClientReq) request;
        MessageData messageData = new MessageData(clientNickname, messageFromClientReqRequest.message);
        model.getMessageList().add(messageData);

        Set<SocketChannel> socketChannelSet = model.getClientTable().keySet();
        MessageFromServerReq messageFromServerReq = new MessageFromServerReq(messageData);
        SendReceiveRequest.broadCast(socketChannelSet, messageFromServerReq);
    }

    private static void handleListParticipantsRequest(SocketChannel socketChannel, ServerModel model) {
        Map<SocketChannel, ClientData> clientTable = model.getClientTable();
        List<ClientData> clientDataList = new ArrayList<>(clientTable.values());
        ClientsListReceiveReq clientsListReceiveReqRequest = new ClientsListReceiveReq(clientDataList);
        SendReceiveRequest.sendRequest(socketChannel, clientsListReceiveReqRequest);
    }
}
