package org.lab2.commands.mathematical;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

public class Sqrt implements Commands {
    public final String commandName = "SQRT";
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public String getCommandName() { return commandName; }

    @Override
    @NeedOneElementsInStack
    public void execute(Context context) throws MyExceptions {
        Deque<Double> stack = context.getStack();
        double num1 = stack.removeLast();
        stack.addLast(Math.sqrt(num1));

        log.info("Executed {} with got value {}", commandName, num1);
    }
}
