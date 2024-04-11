package org.lab2.commands;

import org.lab2.Calculator.Context;
import org.lab2.exceptions.MyExceptions;

public interface Commands {
    void execute(Context context) throws MyExceptions;
    default void setArguments(String[] arguments) throws MyExceptions {}
    String getCommandName();
}
