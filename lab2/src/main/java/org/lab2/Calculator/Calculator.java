package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedNElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;
import org.lab2.readers.CalculatorInputDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;

public class Calculator {
    private Context context;
    private CommandsFactory commandsFactory;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public Calculator() throws Exception {
        this.context = new Context();
        this.commandsFactory = initialFactory();
        if (this.commandsFactory == null) {
            throw new Exception();
        }
        log.info("Calculator created");
    }

    public Context getContext() { return context; }

    public void calculating(CalculatorInputDataReader inputData) {
        log.info("Calculator execute");
        InputArguments arguments = new InputArguments();
        while (inputData.read(arguments)) {
            if (!executeCommand(arguments)) {
                return;
            }
        }
    }

    public boolean executeCommand(InputArguments arguments) {
        Commands command = null;
        try {
            command = commandsFactory.create(arguments.getArguments());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            log.error("creating command ", ex);
        } catch (MyExceptions ex) {
            System.err.println(ex.getErrorInfo());
            log.error("creating command with input {}, msg: {}", arguments.getArguments(), ex);
            return false;
        }

        try {
            executeCommand(command, context);
        } catch (NoSuchMethodException ex) {
            log.error("", ex);
        } catch (MyExceptions ex) {
            log.error("execute command with input {}, msg {}", arguments.getArguments(), ex);
            return false;
        }

        return true;
    }

    private CommandsFactory initialFactory() {
        CommandsFactory commandsFactory = null;
        try {
            commandsFactory = new CommandsFactory();
        } catch (IOException ex) {
            log.error("creating Factory with ", ex);
        } catch (MyExceptions ex) {
            log.error("creating Factory with ", ex);
            System.err.println(ex.getErrorInfo());
        } finally {
            return commandsFactory;
        }
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
