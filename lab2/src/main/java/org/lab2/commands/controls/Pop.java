package org.lab2.commands.controls;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

public class Pop implements Commands {
    public final String commandName = "POP";
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public String getCommandName() { return commandName; }

    @Override
    @NeedOneElementsInStack
    public void execute(Context context) throws MyExceptions {
        Deque<Double> stack = context.getStack();
        double lastElement = stack.getLast();
        stack.removeLast();

        log.info("Executed {} with got value {}", commandName, lastElement);
    }
}
