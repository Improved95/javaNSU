package org.lab2.commands.mathematical;

import org.lab2.commands.Commands;

public abstract class MathematicalCommands implements Commands {
    @Override
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    protected String[] arguments;
}
