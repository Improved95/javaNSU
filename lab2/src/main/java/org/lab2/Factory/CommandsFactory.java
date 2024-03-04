package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.CommandNotFoundException;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.ConfigParser;
import org.lab2.readers.FileParser;

import java.io.InputStream;
import java.util.Map;

public class CommandsFactory {
    private Map<String, String> commandsMap;

    public CommandsFactory() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("org/lab2/Factory/config.txt");

        FileParser configReader = new ConfigParser();
        commandsMap = configReader.parse(inputStream);
    }

    public Commands create(String[] userInput) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, MyExceptions {

        if (commandsMap.isEmpty() || !commandsMap.containsKey(userInput[0])) {
            throw new CommandNotFoundException(userInput[0]);
        }

        Class cl = Class.forName(commandsMap.get(userInput[0]));
        Commands commandObject = (Commands)cl.newInstance();

        /*не знаю зачем добавил это, с тем же успехом все работало бы и без это проверки и без аннотаций*/
        if (commandObject.getClass().isAnnotationPresent(ArgumentsExist.class)) {
            commandObject.setArguments(userInput);
        }



//        commandObject.setArguments(argumentsForObject);
        return commandObject;
    }
}
