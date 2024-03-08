package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.commands.annotations.NeedTwoElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;
import org.lab2.readers.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class Calculator {
    private InputReader inputReader;
    private Map<String, Double> parametersMap;
    private Deque<Double> stack;
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public Calculator(InputReader inputReader) {
        this.inputReader = inputReader;
        this.parametersMap = new HashMap<>();
        this.stack = new ArrayDeque<>();
        log.info("Calculator created");
    }

    public void initialCalculator() {
        calculatorExecution();
    }

    public Map<String, Double> getParametersMap() { return parametersMap; }
    public  Deque<Double> getStack() { return stack; }

    private void calculatorExecution() {
        log.info("Calculator execute");

        CommandsFactory factory = null;
        try {
            factory = new CommandsFactory();
        } catch (IOException ex) {
            log.error("creating Factory with {}", ex.getMessage());
            ex.printStackTrace();
        } catch (MyExceptions ex) {
            log.error("creating Factory with {}", ex.getErrorInfo());
            System.err.println(ex.getErrorInfo());
            return;
        }

        ReturnInputArguments arguments = new ReturnInputArguments();
        while (inputReader.read(arguments)) {
            Commands command = null;
            try {
                command = factory.create(arguments.getArguments());
            } catch (ClassNotFoundException ex) {
                log.error("{}", ex.getMessage());
                System.out.println("Class for command " + arguments.getArguments()[0] + " not found");
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                log.error("{}", ex.getMessage());
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                log.error("{}", ex.getMessage());
                ex.printStackTrace();
            } catch (MyExceptions ex) {
                System.err.println(ex.getErrorInfo());
                log.error("creating calculator command with input {}, msg: {}", arguments.getArguments(), ex.getErrorInfo());
                return;
            }


            try {
                Context context = new Context(parametersMap, stack);
                executeCommand(command, context);
            } catch (NoSuchMethodException ex) {
                log.error("{}", ex.getMessage());
                ex.printStackTrace();
            } catch (MyExceptions ex) {
                log.error("execute command with input {}, msg {}", arguments.getArguments(), ex.getErrorInfo());
                return;
            }
        }
    }

    private void executeCommand(Commands commandObject, Context context) throws NoSuchMethodException, MyExceptions {
        Method method = commandObject.getClass().getMethod("execute", Context.class);
        if (method.isAnnotationPresent(NeedOneElementsInStack.class)) {
            if (context.getStack().size() < 1) {
                throw new NotEnoughElementsException(commandObject.getClass().getSimpleName());
            }
        } else if (method.isAnnotationPresent(NeedTwoElementsInStack.class)) {
            if (context.getStack().size() < 2) {
                throw new NotEnoughElementsException(commandObject.getClass().getSimpleName());
            }
        }
        commandObject.execute(context);
    }
}
