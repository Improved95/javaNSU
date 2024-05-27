package org.lab5.communication.requests;

import org.lab5.communication.ClientDataForReq;

import java.util.List;

public class ClientsListReceiveReq extends Request {
    public final List<ClientDataForReq> listOfClients;

    public ClientsListReceiveReq(List<ClientDataForReq> listOfClients) {
        super(RequestType.CLIENTS_LIST_RECEIVE);
        this.listOfClients = listOfClients;
    }
}
