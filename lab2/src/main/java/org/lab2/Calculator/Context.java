package org.lab2.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Double> parametersMap;
    private Deque<Double> stack;

    public Context() {
        this.parametersMap = new HashMap<>();
        this.stack = new ArrayDeque<>();
    }

    public Map<String, Double> getParametersMap() { return parametersMap; }
    public Deque<Double> getStack() { return stack; }
}
