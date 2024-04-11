package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;

public interface Factory {
    Commands create(String[] userInput) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MyExceptions;
}
