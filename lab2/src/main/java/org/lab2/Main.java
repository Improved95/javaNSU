package org.lab2;

import org.lab2.Calculator.Calculator;
import org.lab2.readers.ConsoleStreamReader;
import org.lab2.readers.FileStreamReader;
import org.lab2.readers.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = null;
        if (args.length == 2) {
            inputReader = new FileStreamReader(args[1]);
        } else {
            inputReader = new ConsoleStreamReader();
        }

        Calculator calculator = new Calculator();
        calculator.initialCalculator();
    }
}
