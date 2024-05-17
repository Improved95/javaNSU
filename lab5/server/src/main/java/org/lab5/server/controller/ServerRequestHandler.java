package org.lab5.server.controller;

import org.lab5.communication.requests.*;

import java.nio.channels.SocketChannel;

public class ServerRequestHandler {
    private static ServerController controller;

    public static void setController(ServerController controller) {
        ServerRequestHandler.controller = controller;
    }

    public static void handle(Request request, SocketChannel socketChannel) {
        switch (request.requestType) {
            case LOGIN -> handleLogin(request, socketChannel);
            case MESSAGE_FROM_CLIENT -> handleMessage(request, socketChannel);
            case CLIENTS_LIST_REQUEST -> handleClientListRequest(socketChannel);
        }
    }

    private static void handleLogin(Request request, SocketChannel socketChannel) {
        LoginReq loginReqRequest = (LoginReq) request;
        controller.loginNewClient(socketChannel, loginReqRequest.nickname);
    }

    private static void handleMessage(Request request, SocketChannel socketChannel) {
        MessageFromClientReq messageFromClientReqRequest = (MessageFromClientReq) request;
        controller.receiveMessageAndBroadcastToAnywhere(messageFromClientReqRequest, socketChannel);
    }

    private static void handleClientListRequest(SocketChannel socketChannel) {
        controller.sendClientList(socketChannel);
    }
}
