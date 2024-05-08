package org.lab4.controller.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {
    public static Properties parse(InputStream inputStream) throws IOException {
        Properties commandsProperties = new Properties();
        commandsProperties.load(inputStream);
        return commandsProperties;
    }
}
