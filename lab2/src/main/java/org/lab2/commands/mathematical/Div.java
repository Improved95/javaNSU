package org.lab2.commands.mathematical;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedNElementsInStack;
import org.lab2.exceptions.DivNullException;
import org.lab2.exceptions.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

public class Div implements Commands {
    public final String commandName = "DIV";
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public String getCommandName() { return commandName; }

    @Override
    @NeedNElementsInStack(requiredNumberOfElements = 2)
    public void execute(Context context) throws MyExceptions {
        Deque<Double> stack = context.getStack();
        double num1 = stack.removeLast();
        double num2 = stack.removeLast();

        if (num1 == 0) {
            throw new DivNullException();
        }

        stack.addLast(num2 / num1);

        log.info("Executed {} with got value {} {}", commandName, num1, num2);
    }
}
