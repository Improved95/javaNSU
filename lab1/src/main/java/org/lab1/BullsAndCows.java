package org.lab1;
public class BullsAndCows {
    public BullsAndCows() {}

    private String hiddenNumber = "";
    private final int quantityNumber = 4;

    private void generateNumber() {
        for (int i = 0; i < quantityNumber; i++) {
            Integer number;
            do {
                number = (int)(Math.random() * 10);
            } while(hiddenNumber.contains(number.toString()));
            hiddenNumber += number;
        }
    }

    private boolean comparateNumber(String inputNumber, String hiddenNumber, Integer cows, Integer bulls) {
        for (int i = 0; i < this.quantityNumber; i++) {
            if (inputNumber.charAt(i) == hiddenNumber.charAt(i)) {
                bulls++;
            } else if (hiddenNumber.contains("" + inputNumber.charAt(i))) {
                cows++;
            }
        }

        return inputNumber == hiddenNumber;
    }

    private void gameplay() {
        String inputNumber;
        boolean gameIsOver;
        ConsoleInput consoleInput = new ConsoleInput();
        do {
            inputNumber = consoleInput.readCorrectNumber(this.quantityNumber);

            Integer cows = 0, bulls = 0;
            gameIsOver = comparateNumber(inputNumber, this.hiddenNumber, cows, bulls);
            System.out.println("Cows: " + cows + "; Bulls: " + bulls);

        } while(!gameIsOver);
    }

    public void initialBullsAndCows() {
        generateNumber();
        gameplay();
        System.out.println("You guessed number!");
    }
}
