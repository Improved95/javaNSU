package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.exceptions.CommandNotFoundException;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.ConfigParser;
import org.lab2.readers.FileParser;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

public class CommandsFactory {
    public CommandsFactory() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("org/lab2/Factory/config.txt");

        FileParser configReader = new ConfigParser();
        commandsMap = configReader.parse(inputStream);
    }

    public Commands create(String className, String[] argumentsForObject) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, MyExceptions {

        if (commandsMap.isEmpty() || !commandsMap.containsKey(className)) {
            throw new CommandNotFoundException(className);
        }

        Class c = Class.forName(commandsMap.get(className));
        Commands commandObject = (Commands)c.newInstance();
        commandObject.setArguments(argumentsForObject);
        return commandObject;
    }

    private Map<String, String> commandsMap;
}
