package org.lab2.commands.mathematical;

import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedTwoElementsInStack;
import org.lab2.exceptions.MyExceptions;

import java.util.Deque;

public class Div implements Commands {
    @Override
    @NeedTwoElementsInStack
    public void execute(Context context) throws MyExceptions {
        Deque<Double> stack = context.getStack();
        double num1 = stack.removeLast();
        double num2 = stack.removeLast();
        stack.addLast(num2 / num1);
    }
}
