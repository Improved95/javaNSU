package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;

import java.io.*;
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
                    command = factory.create(arguments[0], Arrays.copyOfRange(arguments, 1, arguments.length));
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
                    command.execute(stack, parametersMap);
                } catch (MyExceptions ex) {
                    ex.PrintInfo();
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
