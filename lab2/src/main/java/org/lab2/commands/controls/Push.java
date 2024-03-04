package org.lab2.commands.controls;

import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;

import java.util.Deque;
import java.util.Map;

@ArgumentsExist
public class Push implements Commands {
    @Override
    public void execute(Context context) throws MyExceptions {
        Map<String, Double> parametersMap = context.getParametersMap();
        Deque<Double> stack = context.getStack();
        try {
            Double.parseDouble(this.arguments[0]);
        } catch (NumberFormatException ex) {
            if (parametersMap.containsKey(this.arguments[0])) {
                stack.addLast(parametersMap.get(this.arguments[0]));
                return;
            } else {
                throw new IncorrectArgumentException("PUSH");
            }
        }
        stack.addLast(Double.parseDouble(this.arguments[0]));
    }

    public void checkArguments() throws MyExceptions {
        if (arguments.length != 1) {
            throw new IncorrectArgumentException("PUSH");
        }
    }
}
