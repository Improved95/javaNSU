package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public Calculator(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void initialCalculator() {
        calculatorExecution();
    }

    private InputStream inputStream;
    private Map<String, ? extends Number> parametersMap = new HashMap<>();
    private ArrayDeque<? extends Number> stack = new ArrayDeque<>();

    private void calculatorExecution() {
        CommandsFactory factory = new CommandsFactory();
        /*try {
            Commands add =  factory.create("Add");
            add.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String args[] = line.split(" ");
                System.out.println(args[0]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
