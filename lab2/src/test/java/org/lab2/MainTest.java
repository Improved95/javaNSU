package org.lab2;

import org.junit.jupiter.api.*;
import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.InputArguments;
import org.lab2.Factory.CalculatorCommandFactory;
import org.lab2.Factory.Factory;
import org.lab2.commands.Commands;
import org.lab2.exceptions.MyExceptions;
import org.lab2.readers.CalculatorInputDataReader;
import org.lab2.readers.CalculatorStringDataReaderCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainTest {
    @BeforeAll
    static void setup() {}

    @BeforeEach
    void setupThis() {}

    @Test
    void TestCalculator1() throws Exception {
        Calculator calculator = new Calculator();
        Factory calculatorCommandFactory = new CalculatorCommandFactory();

        InputArguments arguments = new InputArguments();

        arguments.setArguments(new String[]{"PUSH", "2"});
        Commands command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        arguments.setArguments(new String[]{"DEFINE", "a", "7"});
        command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        arguments.setArguments(new String[]{"PUSH", "a"});
        command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        arguments.setArguments(new String[]{"ADD"});
        command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        arguments.setArguments(new String[]{"SQRT"});
        command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        Assertions.assertEquals(3, calculator.getContext().getStack().getLast());

        arguments.setArguments(new String[]{"POP"});
        command = calculatorCommandFactory.create(arguments.getArguments());
        calculator.calculate(command);

        Assertions.assertTrue(calculator.getContext().getStack().isEmpty());
    }

    /*@Test
    void TestCalculator2() {
        Calculator calculator = null;
        try {
            calculator = new Calculator();
        } catch (Exception ex) {}

        String input = "DEFINE a 4\n" + "DEFINE b 25\n" + "PUSH a\n" + "PUSH b\n" + "ADD\n" + "PUSH 4\n" + "SUB\n" + "SQRT\n";
        try (CalculatorInputDataReader inputData = new CalculatorStringDataReaderCalculator(input)) {

            calculator.calculating(inputData);
            Assertions.assertEquals(5, calculator.getContext().getStack().getLast());
            Assertions.assertEquals(4, calculator.getContext().getParametersMap().get("a"));
            Assertions.assertEquals(25, calculator.getContext().getParametersMap().get("b"));

        } catch (Exception ex) {}
    }

    @Test
    void TestCalculator3() {
        Calculator calculator = null;
        try {
            calculator = new Calculator();
        } catch (Exception ex) {}
        String input = "PUSH 321\n" + "PUSH 123\n" + "POP\n" + "PUSH 1000\n" + "PUSH 10\n" + "DIV\n" + "MUL\n";
        try (CalculatorInputDataReader inputData = new CalculatorStringDataReaderCalculator(input)) {

            calculator.calculating(inputData);
            Assertions.assertEquals(32100, calculator.getContext().getStack().getLast());

        } catch (Exception ex) {}
    }*/

    @AfterEach
    void teatThis() {}

    @AfterAll
    static void tear() {}
}
