package org.lab2.commands.controls;

import org.lab2.commands.Commands;

public abstract class ControlCommands implements Commands {
    @Override
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    protected String[] arguments;
}
