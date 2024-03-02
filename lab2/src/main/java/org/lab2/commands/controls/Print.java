package org.lab2.commands.controls;

import org.lab2.commands.annotations.WithoutArguments;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

@WithoutArguments
public class Print extends ControlCommands {
    @Override
    public void execute(Deque<Double> stack, Map<String, Double> parametersMap) throws MyExceptions {
        if (stack.size() < 1) {
            throw new NotEnoughElementsException("PRINT");
        }
        System.out.println(stack.getLast());
    }
}
