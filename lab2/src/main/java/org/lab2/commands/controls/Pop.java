package org.lab2.commands.controls;

import org.lab2.Calculator.Context;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.util.Deque;
import java.util.Map;

@NeedOneElementsInStack
public class Pop extends ControlCommands {
    @Override
    public void execute(Context context) throws MyExceptions {
        /*if (stack.size() < 1) {
            throw new NotEnoughElementsException("POP");
        }*/

        Deque<Double> stack = context.getStack();
        stack.removeLast();
    }
}
