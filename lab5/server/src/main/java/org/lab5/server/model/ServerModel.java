package org.lab5.server.model;

import java.util.Properties;

public class ServerModel {
    private Properties serverProperty;

    public int getServerPort() {
        return Integer.parseInt(serverProperty.getProperty("port"));
    }

    public Properties getServerProperty() {
        return serverProperty;
    }

    public void setServerProperty(Properties serverProperty) {
        this.serverProperty = serverProperty;
    }
}
