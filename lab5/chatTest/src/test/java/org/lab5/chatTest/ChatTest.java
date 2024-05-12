package org.lab5.chatTest;

import org.junit.jupiter.api.Test;
import org.lab5.client.client.Client;
import org.lab5.client.controller.ClientController;
import org.lab5.client.controller.SendReceiveRequest;
import org.lab5.client.view.FormDataContext;
import org.lab5.client.requests.Login;
import org.lab5.client.requests.Request;
import org.lab5.server.server.Server;

public class ChatTest {
    @Test
    public void test1() {
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.initial();
        });
        serverThread.start();

        Client client = new Client();
        client.initial();

        ClientController clientController = client.getClientController();
        FormDataContext formDataContext = new FormDataContext("localhost", "65525", "improve");
        clientController.connectToServer(formDataContext);

        Request request = new Login("improve", "xml");
        SendReceiveRequest.sendRequest(client.getClientModel().getClientSocketChannel(), request);
    }
}
