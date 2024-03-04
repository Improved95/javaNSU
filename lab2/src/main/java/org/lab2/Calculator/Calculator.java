package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.commands.annotations.NeedTwoElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;
import org.lab2.readers.InputParser;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class Calculator {
    private InputStream inputStream;
    private Map<String, Double> parametersMap;
    private Deque<Double> stack;

    public Calculator(InputStream inputStream) {
        this.inputStream = inputStream;
        this.parametersMap = new HashMap<>();
        this.stack = new ArrayDeque<>();
    }

    public void initialCalculator() {
        calculatorExecution();
    }

    public Map<String, Double> getParametersMap() { return parametersMap; }
    public  Deque<Double> getStack() { return stack; }

    private void calculatorExecution() {
        CommandsFactory factory = new CommandsFactory();
        String line;

        InputParser inputParser = new InputParser(inputStream);
        try {
            while ((line = br.readLine()) != null) {
                String arguments[] = line.split(" ");

                Commands command = null;
                try {
                    command = factory.create(arguments);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (MyExceptions ex) {
                    ex.PrintInfo();
                    break;
                }

                try {
                    Context context = new Context(parametersMap, stack);
                    executeCommand(command, context);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (MyExceptions ex) {
                    ex.PrintInfo();
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void executeCommand(Commands commandObject, Context context) throws MyExceptions, NoSuchMethodException {
        if (commandObject.getClass().isAnnotationPresent(NeedOneElementsInStack.class)) {
            if (context.getStack().size() < 1) {
                throw new NotEnoughElementsException(commandObject.getClass().getSimpleName());
            }
        } else if (commandObject.getClass().isAnnotationPresent(NeedTwoElementsInStack.class)) {
            if (context.getStack().size() < 2) {
                throw new NotEnoughElementsException(commandObject.getClass().getSimpleName());
            }
        }
        commandObject.execute(context);
    }
}
