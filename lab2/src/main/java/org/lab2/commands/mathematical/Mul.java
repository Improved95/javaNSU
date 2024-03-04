package org.lab2.commands.mathematical;

import org.lab2.Calculator.Context;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

public class Mul extends MathematicalCommands {
    @Override
    public void execute(Context context) throws MyExceptions {
        /*if (stack.size() < 2) {
            throw new NotEnoughElementsException("MUL");
        }*/

        Deque<Double> stack = context.getStack();
        double num1 = stack.removeLast();
        double num2 = stack.removeLast();
        stack.addLast(num1 * num2);
    }
}
