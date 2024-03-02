package org.lab2.commands;

import org.lab2.exceptions.MyExceptions;

import java.util.Deque;
import java.util.Map;

public interface Commands {
    void setArguments(String[] arguments) throws MyExceptions;
    void execute(Deque<Double> stack, Map<String, Double> parametersMap) throws MyExceptions;
    default void checkArguments() throws MyExceptions {}
}
