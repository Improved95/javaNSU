package org.lab2;

import org.junit.jupiter.api.*;
import org.lab2.Calculator.Calculator;
import org.lab2.readers.InputReader;
import org.lab2.readers.StringReader;

public class MainTest {
    @BeforeAll
    static void setup() {}

    @BeforeEach
    void setupThis() {}

    @Test
    void TestCalculator1() {
        String input = "DEFINE a 4\n" + "DEFINE b 25\n" + "PUSH a\n" + "PUSH b\n" + "ADD\n" + "PUSH 4\n" + "SUB\n" + "SQRT\n" + "PRINT";
        InputReader inputReader = new StringReader(input);
        Calculator calculator = new Calculator(inputReader);
        calculator.initialCalculator();

        Assertions.assertEquals(5, calculator.getContext().getStack().getLast());
        Assertions.assertEquals(4, calculator.getContext().getParametersMap().get("a"));
        Assertions.assertEquals(25, calculator.getContext().getParametersMap().get("b"));
    }

    @Test
    void TestCalculator2() {
        String input = "PUSH 123\n" + "PUSH 1000\n" + "PUSH 10\n" + "DIV\n" + "PRINT";
        InputReader inputReader = new StringReader(input);
        Calculator calculator = new Calculator(inputReader);
        calculator.initialCalculator();

        Assertions.assertEquals(100, calculator.getContext().getStack().getLast());
    }

    @Test
    void TestCalculator3() {
        String input = "PUSH 321\n" + "PUSH 123\n" + "POP\n" + "PUSH 1000\n" + "PUSH 10\n" + "DIV\n" + "MUL\n" + "PRINT\n";
        InputReader inputReader = new StringReader(input);
        Calculator calculator = new Calculator(inputReader);
        calculator.initialCalculator();

        Assertions.assertEquals(32100, calculator.getContext().getStack().getLast());
    }

    @AfterEach
    void teatThis() {}

    @AfterAll
    static void tear() {}
}
