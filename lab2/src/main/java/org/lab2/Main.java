package org.lab2;

import org.lab2.Calculator.Calculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File fileInput = new File("C:/improved/coding/java/javaNSU/lab2/src/main/java/org/lab2/input.txt");
        InputStream inputStream = new FileInputStream(fileInput);

        Calculator calculator = new Calculator(inputStream);
        calculator.initialCalculator();
    }
}
