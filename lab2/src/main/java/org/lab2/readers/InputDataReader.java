package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

public interface InputDataReader extends AutoCloseable {
    boolean read(ReturnInputArguments arguments);
}
