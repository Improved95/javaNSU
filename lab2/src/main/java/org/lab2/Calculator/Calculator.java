package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public void initialCalculator() {
        calculatorExecution();
    }

    private Map<String, ? extends Number> parametersMap = new HashMap<>();
    private ArrayDeque<? extends Number> stack = new ArrayDeque<>();

    private void calculatorExecution() {
        CommandsFactory factory = new CommandsFactory();
        try {
            Commands add =  factory.create("Add");
            add.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }
}
