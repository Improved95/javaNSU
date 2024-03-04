package org.lab2.commands.controls;

import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.exceptions.MyExceptions;

import java.util.Deque;
@NeedOneElementsInStack
public class Print implements Commands {
    @Override
    public void execute(Context context) throws MyExceptions {
        Deque<Double> stack = context.getStack();
        System.out.println(stack.getLast());
    }
}
