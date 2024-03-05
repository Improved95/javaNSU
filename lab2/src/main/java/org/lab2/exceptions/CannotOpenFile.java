package org.lab2.exceptions;

public class CannotOpenFile extends MyExceptions {
    public CannotOpenFile(String fileName) {
        super("Cannot open " + fileName + ".");
    }
}
