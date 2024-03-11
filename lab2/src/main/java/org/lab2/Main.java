package org.lab2;

import org.lab2.Calculator.Calculator;
import org.lab2.readers.ConsoleStreamReaderCalculator;
import org.lab2.readers.FileStreamReaderCalculator;
import org.lab2.readers.CalculatorInputDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {

        Calculator calculator = null;
        try {
            calculator = new Calculator();
        } catch (Exception ex) {
            log.error("", ex);
        }

        try (CalculatorInputDataReader inputData = openReader(args)) {
            calculator.calculating(inputData);
        } catch (Exception ex) {
            log.error("Cannot open input data stream, args: {}, exception: {}", args, ex);
            System.err.println("Cannot open input data stream, args:" + args);
        }

    }

    private static CalculatorInputDataReader openReader(String[] args) {
        CalculatorInputDataReader inputReader = null;
        if (args.length == 1) {
            try {
                inputReader = new FileStreamReaderCalculator(args[0]);
            } catch (IOException ex) {
                System.err.println("Cannot open " + args[0] + " file.");
                ex.printStackTrace();
            }
        } else {
            inputReader = new ConsoleStreamReaderCalculator();
        }

        return inputReader;
    }
}
