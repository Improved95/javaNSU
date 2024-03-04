package org.lab2;

import org.lab2.Calculator.Calculator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File fileInput = new File("/Users/improvedmac/Documents/improved/java/javaNSU/lab2/src/main/java/org/lab2/input.txt");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileInput);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Calculator calculator = new Calculator(inputStream);
        calculator.initialCalculator();
    }
}
