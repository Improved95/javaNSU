package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public Calculator(InputStream inputStream) {
        this.inputStream = inputStream;
        this.parametersMap = new HashMap<>();
        this.stack = new ArrayDeque<>();
    }

    public void initialCalculator() {
        calculatorExecution();
    }

    private InputStream inputStream;
    private Map<String, ? extends Number> parametersMap;
    private ArrayDeque<? extends Number> stack;

    private void calculatorExecution() {
        CommandsFactory factory = new CommandsFactory();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String args[] = line.split(" ");

                Commands command = null;
                try {
                    command = factory.create(args[0]);
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

                command.execute();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
