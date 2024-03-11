package org.lab2.readers;

import org.lab2.Calculator.InputArguments;

import java.util.Scanner;

public class ConsoleStreamReaderCalculator implements CalculatorInputDataReader {
    @Override
    public boolean read(InputArguments arguments) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        if (line.equals("exit")) { return false; }

        arguments.setArguments(line.split(" "));
        return true;
    }

    @Override
    public void close() throws Exception {}
}
