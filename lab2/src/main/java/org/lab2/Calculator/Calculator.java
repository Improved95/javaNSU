package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedNElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;
import org.lab2.readers.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;

public class Calculator {
    private InputReader inputReader;
    private Context context;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public Calculator(InputReader inputReader) {
        this.inputReader = inputReader;
        this.context = new Context();
        log.info("Calculator created");
    }

    public Context getContext() { return context; }

    public void initialCalculator() {
        calculatorExecution();
    }

    private void calculatorExecution() {
        log.info("Calculator execute");

        CommandsFactory factory = null;
        try {
            factory = new CommandsFactory();
        } catch (IOException ex) {
            log.error("creating Factory with ", ex);
        } catch (MyExceptions ex) {
            log.error("creating Factory with ", ex);
            System.err.println(ex.getErrorInfo());
            return;
        }

        ReturnInputArguments arguments = new ReturnInputArguments();
        while (inputReader.read(arguments)) {
            Commands command = null;
            try {
                command = factory.create(arguments.getArguments());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                log.error("creating command ", ex);
            } catch (MyExceptions ex) {
                System.err.println(ex.getErrorInfo());
                log.error("creating command with input {}, msg: {}", arguments.getArguments(), ex);
                return;
            }


            try {
                executeCommand(command, context);
            } catch (NoSuchMethodException ex) {
                log.error("", ex);
            } catch (MyExceptions ex) {
                log.error("execute command with input {}, msg {}", arguments.getArguments(), ex);
                return;
            }
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
