package org.lab1;

import java.util.Scanner;

public class ConsoleInput {

    public String readCorrectNumber(final int quantityNumber) {
        String inputNumber;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsCorrect;

        do {
            inputIsCorrect = true;
            System.out.print("Try guess number in " + quantityNumber + " numbers: ");
            inputNumber = scanner.nextLine();

            try {
                Integer.parseInt(inputNumber);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input format.");
                inputIsCorrect = false;
            }
            if (inputNumber.length() != quantityNumber) {
                System.out.println("Too few numbers.");
                inputIsCorrect = false;
            }

        } while(!inputIsCorrect);

//        scanner.close();
        return inputNumber;
    }
}
