package org.lab2.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {
    public Properties parse(InputStream inputStream) throws IOException {
        Properties commandsProperties = new Properties();
        commandsProperties.load(inputStream);
        return commandsProperties;
    }
}
