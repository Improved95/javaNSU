package org.lab2.exceptions;

public class CommandNotFoundException extends MyExceptions {
    public CommandNotFoundException(String nameCommand) {
        super("Command " + nameCommand + " not found.");
    }
}
