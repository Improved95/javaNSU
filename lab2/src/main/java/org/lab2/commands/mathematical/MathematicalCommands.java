package org.lab2.commands.mathematical;

import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;

public abstract class MathematicalCommands implements Commands {
    @Override
    public void setArguments(String[] arguments) throws MyExceptions {
        this.arguments = arguments;
        checkArguments();
    }

    protected String[] arguments;
}
