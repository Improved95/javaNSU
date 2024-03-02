package org.lab2.commands.controls;

import org.lab2.exceptions.IncorrectArgumentException;
import org.lab2.exceptions.MyExceptions;
import java.util.Deque;
import java.util.Map;

public class Define extends ControlCommands {
    @Override
    public void execute(Deque<Double> stack, Map<String, Double> parametersMap) throws MyExceptions {
        if (parametersMap.containsKey(this.arguments[0])) {
            parametersMap.replace(this.arguments[0], Double.parseDouble(this.arguments[1]));
        } else {
            parametersMap.put(this.arguments[0], Double.parseDouble(this.arguments[1]));
        }
    }

    @Override
    public void checkArguments() throws MyExceptions {
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
