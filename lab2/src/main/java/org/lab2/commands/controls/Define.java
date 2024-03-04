package org.lab2.commands.controls;

import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;
import java.util.Map;

@ArgumentsExist
public class Define implements Commands {
    private String parameterName;
    private double parameterValue;

    @Override
    public void execute(Context context) throws MyExceptions {
        Map<String, Double> parametersMap = context.getParametersMap();
        if (parametersMap.containsKey(parameterName)) {
            parametersMap.replace(parameterName, parameterValue);
        } else {
            parametersMap.put(parameterName, parameterValue);
        }
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
