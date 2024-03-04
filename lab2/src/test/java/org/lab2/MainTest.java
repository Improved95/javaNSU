package org.lab2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lab2.Calculator.Calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {
    @BeforeAll
    static void setup() {}

    @BeforeEach
    void setupThis() {}

    @Test
    void TestCalculator1() {
        String input = "DEFINE a 4\n" + "DEFINE b 25\n" + "PUSH a\n" + "PUSH b\n" + "ADD\n" + "PUSH 4\n" + "SUB\n" + "SQRT\n" + "PRINT";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(inputStream);
        calculator.initialCalculator();

        Assertions.assertEquals(5, calculator.getStack().getLast());
        Assertions.assertEquals(4, calculator.getParametersMap().get("a"));
        Assertions.assertEquals(25, calculator.getParametersMap().get("b"));
    }

    @Test
    void TestCalculator2() {
        String input = "PUSH 123\n" + "PUSH 1000\n" + "PUSH 10\n" + "DIV\n" + "PRINT";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(inputStream);
        calculator.initialCalculator();

        Assertions.assertEquals(100, calculator.getStack().getLast());
    }

    @Test
    void TestCalculator3() {
        String input = "PUSH 321\n" + "PUSH 123\n" + "POP\n" + "PUSH 1000\n" + "PUSH 10\n" + "DIV\n" + "MUL\n" + "PRINT\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Calculator calculator = new Calculator(inputStream);
        calculator.initialCalculator();

        Assertions.assertEquals(32100, calculator.getStack().getLast());
    }

    @AfterEach
    void teatThis() {}

    @AfterAll
    static void tear() {}
}
