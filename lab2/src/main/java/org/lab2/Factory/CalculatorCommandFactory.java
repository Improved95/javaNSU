package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.CannotOpenFile;
import org.lab2.exceptions.CommandNotFoundException;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.ConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CalculatorCommandFactory implements Factory {
    private Properties commandsProperties;
    private static final Logger log = LoggerFactory.getLogger(CalculatorCommandFactory.class);

    public CalculatorCommandFactory() throws IOException, MyExceptions {
        try (InputStream inputStream = getClass().getResourceAsStream("../../../config.txt")) {
            if (inputStream == null) {
                throw new CannotOpenFile("FactoryConfig");
            }

            ConfigParser configReader = new ConfigParser();
            commandsProperties = configReader.parse(inputStream);
            log.info("Factory created.");
        }
    }

    public Commands create(String[] userInput) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, MyExceptions {

        if (commandsProperties.isEmpty() || !commandsProperties.containsKey(userInput[0])) {
            throw new CommandNotFoundException(userInput[0]);
        }

        Class cl = Class.forName(commandsProperties.getProperty(userInput[0]));
        Commands commandObject = (Commands)cl.newInstance();

        if (commandObject.getClass().isAnnotationPresent(ArgumentsExist.class)) {
            commandObject.setArguments(userInput);
        }
        return commandObject;
    }
}
