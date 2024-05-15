package org.lab5.client.controller;

import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;
import org.lab5.client.model.ChatAreaStatus;
import org.lab5.communication.requests.ClientsListReceiveReq;
import org.lab5.communication.requests.MessageFromServerReq;
import org.lab5.communication.requests.MessagesListReq;
import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.notification.NotificationReq;

public class ClientRequestHandler {
    private static ClientController controller;

    public static void setController(ClientController controller) {
        ClientRequestHandler.controller = controller;
    }

    public static void handle(Request request, ClientModel model) {
        switch (request.requestType) {
            case TRANSPORT_PROTOCOL -> handleTransportProtocol();
            case CLIENTS_LIST_RECEIVE -> handleClientsListReceive(request, model);
            case MESSAGE_FROM_SERVER -> handleMessageFromServer(request, model);
            case MESSAGE_LIST -> handleMessageList(request, model);
            case NOTIFICATION -> handleNotification(request, model);
        }
    }

    private static void handleTransportProtocol() {
        controller.loginToServer();
    }

    private static void handleClientsListReceive(Request request, ClientModel model) {
        ClientsListReceiveReq clientsListReceiveReq = (ClientsListReceiveReq) request;
        model.setClientDataList(clientsListReceiveReq.listOfClients);
        model.setClientListStatus(ClientListStatus.EXIST);
    }

    private static void handleMessageList(Request request, ClientModel model) {
        MessagesListReq messagesListReq = (MessagesListReq) request;
        model.getMessagesList().addAll(messagesListReq.messagesList);
        model.setChatAreaStatus(ChatAreaStatus.UPDATE_FULL_LIST);
    }

    private static void handleMessageFromServer(Request request, ClientModel model) {
        MessageFromServerReq messageFromServerReq = (MessageFromServerReq) request;
        model.getMessagesList().add(messageFromServerReq.messageData);
        model.setChatAreaStatus(ChatAreaStatus.ADD_MESSAGE);
    }

    private static void handleNotification(Request request, ClientModel model) {
        NotificationReq notificationReq = (NotificationReq) request;
        model.getNotificationDataList().add(notificationReq.notificationData);
        model.setChatAreaStatus(ChatAreaStatus.ADD_NOTIFICATION);
    }
}
