package org.lab2.commands.mathematical;

import org.lab2.commands.annotations.WithoutArguments;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

@WithoutArguments
public class Div extends MathematicalCommands {
    @Override
    public void execute(Deque<Double> stack, Map<String, Double> parametersMap) throws MyExceptions {
        if (stack.size() < 2) {
            throw new NotEnoughElementsException("DIV");
        }
        double num1 = stack.removeLast();
        double num2 = stack.removeLast();
        stack.addLast(num2 / num1);
    }
}
