package org.lab2.Calculator;

import java.util.Deque;
import java.util.Map;

public class Context {
    private Map<String, Double> parametersMap;
    private Deque<Double> stack;

    public Context(Map<String, Double> parametersMap, Deque<Double> stack) {
        this.parametersMap = parametersMap;
        this.stack = stack;
    }

    public Map<String, Double> getParametersMap() { return parametersMap; }
    public Deque<Double> getStack() { return stack; }
}
