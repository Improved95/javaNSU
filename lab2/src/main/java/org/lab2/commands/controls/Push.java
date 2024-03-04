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
    private String parameterValue;

    @Override
    public void execute(Context context) throws MyExceptions {
        Map<String, Double> parametersMap = context.getParametersMap();
        Deque<Double> stack = context.getStack();
        try {
            Double.parseDouble(parameterValue);
        } catch (NumberFormatException ex) {
            if (parametersMap.containsKey(parameterValue)) {
                stack.addLast(parametersMap.get(parameterValue));
                return;
            } else {
                throw new IncorrectArgumentException("PUSH");
            }
        }
        stack.addLast(Double.parseDouble(parameterValue));
    }

    @Override
    public void setArguments(String[] arguments) throws MyExceptions {
        checkArguments(arguments);
        this.parameterValue = arguments[1];
    }

    private void checkArguments(String[] arguments) throws MyExceptions {
        if (arguments.length != 1 + 1) {
            throw new IncorrectArgumentException("PUSH");
        }
    }
}
