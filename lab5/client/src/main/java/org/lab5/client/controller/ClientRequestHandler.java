package org.lab5.client.controller;

import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;
import org.lab5.client.model.MessagesListStatus;
import org.lab5.communication.requests.ClientsListReceiveReq;
import org.lab5.communication.requests.MessageFromServerReq;
import org.lab5.communication.requests.MessagesListReq;
import org.lab5.communication.requests.Request;

public class ClientRequestHandler {
    public static void handle(Request request, ClientModel model) {
        switch (request.requestType) {
            case CLIENTS_LIST_RECEIVE -> handleClientsListReceive(request, model);
            case MESSAGE_FROM_SERVER -> handleMessageFromServer(request, model);
            case MESSAGE_LIST -> handleMessageList(request, model);
        }
    }

    private static void handleClientsListReceive(Request request, ClientModel model) {
        ClientsListReceiveReq clientsListReceiveReq = (ClientsListReceiveReq) request;
        model.setClientDataList(clientsListReceiveReq.listOfClients);
        model.setClientListStatus(ClientListStatus.EXIST);
    }

    private static void handleMessageList(Request request, ClientModel model) {
        MessagesListReq messagesListReq = (MessagesListReq) request;
        model.getMessagesList().addAll(messagesListReq.messagesList);
        model.setMessagesListStatus(MessagesListStatus.UPDATE_FULL_LIST);
    }

    private static void handleMessageFromServer(Request request, ClientModel model) {
        MessageFromServerReq messageFromServerReq = (MessageFromServerReq) request;
        model.getMessagesList().add(messageFromServerReq.messageData);
        model.setMessagesListStatus(MessagesListStatus.ADD_MESSAGE);
    }
}
