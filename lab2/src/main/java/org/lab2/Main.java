package org.lab2;

import org.lab2.Calculator.Calculator;
import org.lab2.readers.ConsoleStreamReader;
import org.lab2.readers.FileStreamReader;
import org.lab2.readers.InputReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(InputReader inputReader = openReader(args)) {
        /*try {
            inputReader = new FileStreamReader("/Users/improvedmac/Documents/improved/java/javaNSU/lab2/src/main/java/org/lab2/input.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

            Calculator calculator = new Calculator(inputReader);
            calculator.initialCalculator();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static InputReader openReader(String[] args) {
        InputReader inputReader = null;
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
