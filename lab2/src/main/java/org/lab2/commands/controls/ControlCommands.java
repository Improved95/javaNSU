package org.lab2.commands.controls;

import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;

public abstract class ControlCommands implements Commands {
    @Override
    public void setArguments(String[] arguments) throws MyExceptions {
        this.arguments = arguments;
        checkArguments();
    }

    protected String[] arguments;
}
