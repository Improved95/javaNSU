package org.lab2;

import org.lab2.Calculator.Calculator;
import org.lab2.readers.ConsoleStreamReader;
import org.lab2.readers.FileStreamReader;
import org.lab2.readers.InputDataReader;
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

        try (InputDataReader inputData = openReader(args)) {
            calculator.calculating(inputData);
        } catch (Exception ex) {
            log.error("Cannot open input data stream, args: {}, exception: {}", args, ex);
            System.err.println("Cannot open input data stream, args:" + args);
        }

    }

    private static InputDataReader openReader(String[] args) {
        InputDataReader inputReader = null;
        if (args.length == 1) {
            try {
                inputReader = new FileStreamReader(args[0]);
            } catch (IOException ex) {
                System.err.println("Cannot open " + args[0] + " file.");
                ex.printStackTrace();
            }
        } else {
            inputReader = new ConsoleStreamReader();
        }
        return inputReader;
    }
}
