package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.CommandNotFoundException;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.ConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandsFactory {
    private Properties commandsProperties;

    public CommandsFactory() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("org/lab2/Factory/config.txt");

        ConfigParser configReader = new ConfigParser();
        commandsProperties = configReader.parse(inputStream);
    }

    public Commands create(String[] userInput) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, MyExceptions {

        if (commandsProperties.isEmpty() || !commandsProperties.containsKey(userInput[0])) {
            throw new CommandNotFoundException(userInput[0]);
        }

        Class cl = Class.forName(commandsProperties.getProperty(userInput[0]));
        Commands commandObject = (Commands)cl.newInstance();

        /*не знаю зачем добавил это, с тем же успехом все работало бы и без этой проверки и без аннотаций*/
        if (commandObject.getClass().isAnnotationPresent(ArgumentsExist.class)) {
            commandObject.setArguments(userInput);
        }
        return commandObject;
    }
}
