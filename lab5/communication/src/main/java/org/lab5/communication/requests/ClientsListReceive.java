package org.lab5.communication.requests;

import org.lab5.communication.ClientData;

import java.util.List;

public class ClientsListReceive extends Request {
    public final List<ClientData> listOfClients;

    public ClientsListReceive(List<ClientData> listOfClients) {
        super(RequestType.CLIENTS_LIST_RECEIVE);
        this.listOfClients = listOfClients;
    }
}
