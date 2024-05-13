package org.lab5.server.server;

import org.lab5.communication.requests.Login;
import org.lab5.communication.requests.Request;
import org.lab5.server.model.ClientData;
import org.lab5.server.model.ServerModel;

import java.nio.channels.SocketChannel;

public class RequestHandler {
    public static void handle(Request request, SocketChannel socketChannel, ServerModel model) {
        switch (request.requestType) {
            case LOGIN -> handleLogin(request, socketChannel, model);
        }
    }

    private static void handleLogin(Request request, SocketChannel socketChannel, ServerModel model) {
        Login loginRequest = (Login) request;
        ClientData clientData = new ClientData(loginRequest.nickname, loginRequest.messageType);
        model.getClientTable().put(socketChannel, clientData);
    }
}
