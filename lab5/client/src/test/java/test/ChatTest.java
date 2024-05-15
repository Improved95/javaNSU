package test;

import org.junit.jupiter.api.Test;
import org.lab5.client.client.Client;
import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.requests.LoginReq;
import org.lab5.communication.requests.Request;
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
        ClientModel clientModel = client.getModel();
        clientModel.setServerIP("localhost");
        clientModel.setServerSocket(65525);
        clientController.connectToServer();

        Request request = new LoginReq("improve", "xml");
        SendReceiveRequest.sendRequest(client.getModel().getClientSocketChannel(), request);
    }
}
