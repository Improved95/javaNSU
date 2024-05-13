package org.lab5.communication.requests;

import org.lab5.communication.ClientData;

import java.util.List;

public class ListOfClients extends Request {
    public final List<ClientData> listOfClients;

    public ListOfClients(List<ClientData> listOfClients) {
        super(RequestType.LIST_OF_CLIENTS);
        this.listOfClients = listOfClients;
    }
}
