package org.lab2.commands;

import java.util.Deque;
import java.util.Map;

public interface Commands {
    void execute(Deque<? extends Number> stack, Map<String, ? extends Number> parametersMap);
}
