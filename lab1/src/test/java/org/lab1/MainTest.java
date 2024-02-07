package org.lab1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {}

    @Test
    void testInput() {
        ConsoleInput consoleInput = new ConsoleInput();
        Assertions.assertTrue(consoleInput.inputIsCorrect("1234", 4));
        Assertions.assertFalse(consoleInput.inputIsCorrect("1234e", 4));
        Assertions.assertFalse(consoleInput.inputIsCorrect("123", 4));
    }

    @Test
    void testGame() {
        System.out.println("Test executed.");
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.setHiddenNumber("5894");
        Assertions.assertEquals(0, bullsAndCows.countBullsNumber("1235"));
        Assertions.assertEquals(2, bullsAndCows.countBullsNumber("5234"));
        Assertions.assertEquals(1, bullsAndCows.countCowsNumber("5642"));
        Assertions.assertEquals(2, bullsAndCows.countCowsNumber("1245"));

        Assertions.assertTrue(bullsAndCows.countBullsNumber("5894") == bullsAndCows.getLenghtNumber());
    }

    @AfterEach
    void teatThis() {}

    @AfterAll
    static void tear() {}
}
