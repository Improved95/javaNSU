package org.lab2.commands.mathematical;

import org.lab2.Calculator.Context;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

@NeedOneElementsInStack
public class Sqrt extends MathematicalCommands {
    @Override
    public void execute(Context context) throws MyExceptions {
        /*if (stack.size() < 1) {
            throw new NotEnoughElementsException("SQRT");
        }*/

        Deque<Double> stack = context.getStack();
        double num1 = stack.removeLast();
        stack.addLast(Math.sqrt(num1));
    }
}
