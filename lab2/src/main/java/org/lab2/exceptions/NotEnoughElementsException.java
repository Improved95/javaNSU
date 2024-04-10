package org.lab2.exceptions;

public class NotEnoughElementsException extends MyExceptions {
    public NotEnoughElementsException(String nameOperation) {
        super("Not enough elements in stack for " + nameOperation + ".");
    }
}
