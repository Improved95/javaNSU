package org.lab2.readers;

import org.lab2.Calculator.InputArguments;

public interface CalculatorInputDataReader extends AutoCloseable {
    boolean read(InputArguments arguments);
}
