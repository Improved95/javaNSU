package org.lab5.server.model;

import org.lab5.communication.ClientDataForReq;
import org.lab5.communication.MessageData;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class ServerModel {
    private Properties serverProperty;
    private ServerSocketChannel serverSocketChannel;

    private List<MessageData> messageList = new ArrayList<>();
    private Map<SocketChannel, ClientData> clientTable = new HashMap<>();

    public int getServerPort() {
        return Integer.parseInt(serverProperty.getProperty("port"));
    }

    public Properties getServerProperty() {
        return serverProperty;
    }

    public ServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    public void setServerProperty(Properties serverProperty) {
        this.serverProperty = serverProperty;
    }

    public List<MessageData> getMessageList() {
        return messageList;
    }

    public Map<SocketChannel, ClientData> getClientTable() {
        return clientTable;
    }
}
