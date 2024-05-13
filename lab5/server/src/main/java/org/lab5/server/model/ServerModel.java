package org.lab5.server.model;

import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServerModel {
    private Properties serverProperty;
    private Map<SocketChannel, ClientData> clientTable = new HashMap<>();

    public int getServerPort() {
        return Integer.parseInt(serverProperty.getProperty("port"));
    }

    public Properties getServerProperty() {
        return serverProperty;
    }

    public void setServerProperty(Properties serverProperty) {
        this.serverProperty = serverProperty;
    }

    public Map<SocketChannel, ClientData> getClientTable() {
        return clientTable;
    }
}
