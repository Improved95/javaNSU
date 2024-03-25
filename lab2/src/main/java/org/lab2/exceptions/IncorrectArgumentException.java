package org.lab2.exceptions;

public class IncorrectArgumentException extends MyExceptions {
    public IncorrectArgumentException(String nameCommand) {
        super("Incorrect argument in " + nameCommand + " command.");
    }
}
