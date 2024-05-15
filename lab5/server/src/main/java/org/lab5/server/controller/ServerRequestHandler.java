package org.lab5.server.controller;

import org.lab5.communication.ClientData;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.requests.*;
import org.lab5.communication.MessageData;
import org.lab5.communication.requests.TransportProtocolReq;
import org.lab5.server.model.ServerModel;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServerRequestHandler {
    private static ServerController controller;

    public static void setController(ServerController controller) {
        ServerRequestHandler.controller = controller;
    }

    public static void handle(Request request, SocketChannel socketChannel, ServerModel model) {
        switch (request.requestType) {
            case TRANSPORT_PROTOCOL -> handleTransportProtocol(request, socketChannel, model);
            case LOGIN -> handleLogin(request, socketChannel);
            case MESSAGE_FROM_CLIENT -> handleMessage(request, socketChannel, model);
            case CLIENTS_LIST_REQUEST -> handleListParticipantsRequest(socketChannel, model);
        }
    }

    private static void handleTransportProtocol(Request request, SocketChannel socketChannel, ServerModel model) {
        TransportProtocolReq transportProtocolReq = (TransportProtocolReq) request;

        ClientData clientData;
        if (transportProtocolReq.transportProtocolByte == (byte)10) {
            clientData = new ClientData(TransferProtocol.SERIALIZABLE);
            System.out.println("SERIALIZABLE");
        } else {
            clientData = new ClientData(TransferProtocol.XML);
            System.out.println("XML");
        }
        model.getClientTable().put(socketChannel, clientData);

        SendReceiveRequest.sendRequest(socketChannel, new TransportProtocolReq((byte) 0));
    }

    private static void handleLogin(Request request, SocketChannel socketChannel) {
        LoginReq loginReqRequest = (LoginReq) request;
        controller.loginNewClient(socketChannel, loginReqRequest.nickname);
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
