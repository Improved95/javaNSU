package org.lab2.commands.controls;

import org.lab2.Calculator.Context;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.ArgumentsExist;
import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;
import java.util.Map;

@ArgumentsExist
public class Define implements Commands {
    @Override
    public void execute(Context context) throws MyExceptions {
        Map<String, Double> parametersMap = context.getParametersMap();
        if (parametersMap.containsKey(this.arguments[0])) {
            parametersMap.replace(this.arguments[0], Double.parseDouble(this.arguments[1]));
        } else {
            parametersMap.put(this.arguments[0], Double.parseDouble(this.arguments[1]));
        }
    }

    @Override
    public void setArguments(String[] arguments) {

    }

    private void checkArguments() throws MyExceptions {
        if (arguments.length != 2) {
            throw new IncorrectArgumentException("DEFINE");
        }
        try {
            Double.parseDouble(this.arguments[1]);
        } catch (NumberFormatException ex) {
            throw new IncorrectArgumentException("DEFINE");
        }
    }
}
