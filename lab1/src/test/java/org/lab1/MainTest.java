package org.lab1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MainTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {}

    @Test
    void testGameOne() {
        System.out.println("Test executed.");
        BullsAndCows bullsAndCows = new BullsAndCows();


    }

    @AfterEach
    void teatThis() {}

    @AfterAll
    static void tear() {}
}
