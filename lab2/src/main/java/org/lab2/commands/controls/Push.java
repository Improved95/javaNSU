package org.lab2.commands.controls;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.Map;

@ArgumentsExist
public class Push implements Commands {
    public final String commandName = "PUSH";
    private String parameterValue;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public String getCommandName() { return commandName; }

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

        log.info("Executed {} with arguments {}", commandName, parameterValue);
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
