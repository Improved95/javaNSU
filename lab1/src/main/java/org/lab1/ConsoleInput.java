package org.lab1;

import java.util.Scanner;

public class ConsoleInput {

    public boolean inputIsCorrect(final String inputNumber, final int quantityNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect input format.");
            return false;
        }
        if (inputNumber.length() != quantityNumber) {
            System.out.println("Too few numbers.");
            return false;
        }
        return true;
    }

    public String readCorrectNumber(final int quantityNumber) {
        String inputNumber = "";
        Scanner scanner = new Scanner(System.in);

        while(!inputIsCorrect(inputNumber, quantityNumber)) {
            System.out.print("Try guess number in " + quantityNumber + " numbers: ");
            inputNumber = scanner.nextLine();
        }

//        scanner.close();
        return inputNumber;
    }
}
