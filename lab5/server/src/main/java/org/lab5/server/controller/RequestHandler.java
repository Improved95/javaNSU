package org.lab5.server.controller;

import org.lab5.communication.ClientData;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.requests.ListOfClients;
import org.lab5.communication.requests.Login;
import org.lab5.communication.requests.Message;
import org.lab5.communication.requests.Request;
import org.lab5.communication.MessageData;
import org.lab5.server.model.ServerModel;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class RequestHandler {
    public static void handle(Request request, SocketChannel socketChannel, ServerModel model) {
        switch (request.requestType) {
            case LOGIN -> handleLogin(request, socketChannel, model);
            case MESSAGE -> handleMessage(request, socketChannel, model);
            case LIST_OF_CLIENTS_REQUEST -> handleListParticipantsRequest(socketChannel, model);
        }
    }

    private static void handleLogin(Request request, SocketChannel socketChannel, ServerModel model) {
        Login loginRequest = (Login) request;
        model.getClientTable().get(socketChannel).setNickname(loginRequest.nickname);
    }

    private static void handleMessage(Request request, SocketChannel socketChannel, ServerModel serverModel) {
        String clientNickname = serverModel.getClientTable().get(socketChannel).getNickname();
        Message messageRequest = (Message) request;
        MessageData messageData = new MessageData(clientNickname, messageRequest.message);
        serverModel.getMessageList().add(messageData);
    }

    private static void handleListParticipantsRequest(SocketChannel socketChannel, ServerModel model) {
        Map<SocketChannel, ClientData> clientTable = model.getClientTable();
        List<ClientData> clientDataList = new ArrayList<>(clientTable.values());
        ListOfClients listOfClientsRequest = new ListOfClients(clientDataList);
        SendReceiveRequest.sendRequest(socketChannel, listOfClientsRequest);
    }
}
