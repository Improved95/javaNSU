package org.lab2.commands.mathematical;

import java.util.Deque;
import java.util.Map;

public class Add extends MathematicalCommands {
    @Override
    public void execute(Deque<? extends Number> stack, Map<String, ? extends Number> parametersMap) {
        Number num1 = stack.removeLast();
        Number num2 = stack.removeLast();
        stack.addLast(Integer);
    }
}
