package org.lab2;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.InputArguments;
import org.lab2.Factory.CalculatorCommandFactory;
import org.lab2.Factory.Factory;
import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.ConsoleStreamReaderCalculator;
import org.lab2.readers.FileStreamReaderCalculator;
import org.lab2.readers.CalculatorInputDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.System.exit;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Factory calculatorCommandFactory = null;
        try {
            calculatorCommandFactory = new CalculatorCommandFactory();
        } catch (IOException ex) {
            log.error("", ex);
        } catch (MyExceptions ex) {
            System.err.println(ex.getErrorInfo());
            log.error("", ex);
            return;
        }

        try (CalculatorInputDataReader inputData = openReader(args)) {

            calculatingInputData(calculator, inputData, calculatorCommandFactory);

        } catch (Exception ex) {
            log.error("Cannot open input data stream, args: {}, exception: {}", args, ex);
            System.err.println("Cannot open input data stream, args:" + args);
        }

    }

    private static void calculatingInputData(Calculator calculator, CalculatorInputDataReader inputData, Factory calculatorCommandFactory) {
        InputArguments arguments = new InputArguments();
        while (inputData.read(arguments)) {
            Commands command = null;
            try {
                command = calculatorCommandFactory.create(arguments.getArguments());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                log.error("creating command ", ex);
            } catch (MyExceptions ex) {
                System.err.println(ex.getErrorInfo());
                log.error("creating command with input {}, msg: {}", arguments.getArguments(), ex);
                continue;
            }

            if (!calculator.calculate(command)) {
                return;
            }
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
