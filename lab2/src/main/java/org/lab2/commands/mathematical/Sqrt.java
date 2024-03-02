package org.lab2.commands.mathematical;

import org.lab2.commands.annotations.WithoutArguments;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

@WithoutArguments
public class Sqrt extends MathematicalCommands {
    @Override
    public void execute(Deque<Double> stack, Map<String, Double> parametersMap) throws MyExceptions {
        if (stack.size() < 1) {
            throw new NotEnoughElementsException("SQRT");
        }
        double num1 = stack.removeLast();
        stack.addLast(Math.sqrt(num1));
    }
}
