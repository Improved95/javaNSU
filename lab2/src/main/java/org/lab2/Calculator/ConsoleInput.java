package org.lab2.Calculator;

import java.util.Scanner;

public class ConsoleInput {
    public String readCommand() {
        Scanner scanner = new Scanner(System.in);

        String inputCommand = scanner.nextLine();

        scanner.close();
        return inputCommand;
    }
}
