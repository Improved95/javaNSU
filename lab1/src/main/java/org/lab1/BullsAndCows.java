package org.lab1;
public class BullsAndCows {
    public BullsAndCows() {
        generateNumber();
    }

    public String getHiddenNumber() { return hiddenNumber; }
    public int getQuantityNumber() { return quantityNumber; }

    public void initialBullsAndCows() {
        generateNumber();
        gameplay();
        System.out.println("You guessed number! Answer: " + this.hiddenNumber + ".");
    }

    public int countBullsNumber(String inputNumber) {
        int bulls = 0;
        for (int i = 0; i < this.quantityNumber; i++) {
            if (inputNumber.charAt(i) == hiddenNumber.charAt(i)) {
                bulls += 1;
            }
        }
        return bulls;
    }

    public int countCowsNumber(String inputNumber) {
        int cows = 0;
        for (int i = 0; i < this.quantityNumber; i++) {
            if (hiddenNumber.contains("" + inputNumber.charAt(i))) {
                cows += 1;
            }
        }
        return cows;
    }

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

    private void gameplay() {
        String inputNumber;
        ConsoleInput consoleInput = new ConsoleInput();
        do {
            inputNumber = consoleInput.readCorrectNumber(this.quantityNumber);

            int cows, bulls;
            cows = countCowsNumber(inputNumber);
            bulls = countBullsNumber(inputNumber);

            System.out.println("Cows: " + cows + "; Bulls: " + bulls);

        } while(!inputNumber.equals(hiddenNumber));
    }
}
