package org.lab2.Calculator;

import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedNElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Calculator {
    private Context context;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public Calculator() {
        this.context = new Context();
        log.info("Calculator created");
    }

    public Context getContext() { return context; }

    public boolean calculate(Commands commands) {
        try {
            executeCommand(commands, context);
        } catch (NoSuchMethodException ex) {
            log.error("", ex);
        } catch (MyExceptions ex) {
            log.error("execute command with input {}", ex);
            return false;
        }

        return true;
    }

    private void executeCommand(Commands commandObject, Context context) throws NoSuchMethodException, MyExceptions {
        Method method = commandObject.getClass().getMethod("execute", Context.class);
        if (method.isAnnotationPresent(NeedNElementsInStack.class)) {
            if (context.getStack().size() < method.getAnnotation(NeedNElementsInStack.class).requiredNumberOfElements()) {
                throw new NotEnoughElementsException(commandObject.getClass().getSimpleName());
            }
        }
        commandObject.execute(context);
    }
}
