package org.lab2.commands.controls;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@ArgumentsExist
public class Define implements Commands {
    public final String commandName = "DEFINE";
    private String parameterName;
    private double parameterValue;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public String getCommandName() { return commandName; }

    @Override
    public void execute(Context context) throws MyExceptions {
        Map<String, Double> parametersMap = context.getParametersMap();
        if (parametersMap.containsKey(parameterName)) {
            parametersMap.replace(parameterName, parameterValue);
        } else {
            parametersMap.put(parameterName, parameterValue);
        }

        log.info("Executed {} with arguments {} {}", commandName, parameterName, parameterValue);
    }

    @Override
    public void setArguments(String[] arguments) throws MyExceptions {
        checkArguments(arguments);
        this.parameterName = arguments[1];
        this.parameterValue = Double.parseDouble(arguments[2]);
    }

    private void checkArguments(String[] arguments) throws MyExceptions {
        if (arguments.length != 2 + 1) {
            throw new IncorrectArgumentException("DEFINE");
        }
        try {
            Double.parseDouble(arguments[2]);
        } catch (NumberFormatException ex) {
            throw new IncorrectArgumentException("DEFINE");
        }
    }
}
