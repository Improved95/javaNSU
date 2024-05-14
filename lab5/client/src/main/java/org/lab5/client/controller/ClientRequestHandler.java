package org.lab5.client.controller;

import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;
import org.lab5.communication.requests.ClientsListReceive;
import org.lab5.communication.requests.Request;

public class ClientRequestHandler {
    public static void handle(Request request, ClientModel model) {
        switch (request.requestType) {
            case CLIENTS_LIST_RECEIVE ->  handleClientsListReceive(request, model);
        }
    }

    private static void handleClientsListReceive(Request request, ClientModel model) {
        ClientsListReceive clientsListReceive = (ClientsListReceive) request;
        model.setClientDataList(clientsListReceive.listOfClients);
        model.setClientListStatus(ClientListStatus.EXIST);
    }
}
