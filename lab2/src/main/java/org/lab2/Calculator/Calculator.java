package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.commands.annotations.NeedOneElementsInStack;
import org.lab2.commands.annotations.NeedTwoElementsInStack;
import org.lab2.exceptions.MyExceptions;
import org.lab2.exceptions.NotEnoughElementsException;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class Calculator {
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

    private InputStream inputStream;
    private Map<String, Double> parametersMap;
    private Deque<Double> stack;

    private void calculatorExecution() {
        CommandsFactory factory = new CommandsFactory();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
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
        Method method = commandObject.getClass().getMethod("execute", Context.class);
        if (method.isAnnotationPresent(NeedOneElementsInStack.class)) {
            if (context.getStack().size() < 1) {
                throw new NotEnoughElementsException("Some method");
            }
        } else if (method.isAnnotationPresent(NeedTwoElementsInStack.class)) {
            if (context.getStack().size() < 2) {
                throw new NotEnoughElementsException("Some method");
            }
        }
        commandObject.execute(context);
    }
}
