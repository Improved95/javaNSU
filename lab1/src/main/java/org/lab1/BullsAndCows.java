package org.lab1;
public class BullsAndCows {
    public BullsAndCows() {
        generateNumber();
    }

    public String getHiddenNumber() { return hiddenNumber; }
    public int getLenghtNumber() { return lenghtNumber; }

    public void setHiddenNumber(String hiddenNumber) { this.hiddenNumber = hiddenNumber; }

    public void initialBullsAndCows() {
        gameplay();
        System.out.println("You guessed number! Answer: " + this.hiddenNumber + ".");
    }

    public int countBullsNumber(String inputNumber) {
        int bulls = 0;
        for (int i = 0; i < this.lenghtNumber; i++) {
            if (inputNumber.charAt(i) == hiddenNumber.charAt(i)) {
                bulls += 1;
            }
        }
        return bulls;
    }

    public int countCowsNumber(String inputNumber) {
        int cows = 0;
        for (int i = 0; i < this.lenghtNumber; i++) {
            if (hiddenNumber.contains("" + inputNumber.charAt(i)) && inputNumber.charAt(i) != hiddenNumber.charAt(i)) {
                cows += 1;
            }
        }
        return cows;
    }

    private String hiddenNumber = "";
    private final int lenghtNumber = 4;

    private void generateNumber() {
        for (int i = 0; i < lenghtNumber; i++) {
            Integer number;
            do {
                number = (int)(Math.random() * 10);
            } while(hiddenNumber.contains(number.toString()));
            hiddenNumber += number;
        }
    }

    private void gameplay() {
        String inputNumber;
        int cows, bulls;
        ConsoleInput consoleInput = new ConsoleInput();

        do {
            inputNumber = consoleInput.readCorrectNumber(this.lenghtNumber);
            bulls = countBullsNumber(inputNumber);
            cows = countCowsNumber(inputNumber);

            System.out.println("Cows: " + cows + "; Bulls: " + bulls);

        } while(bulls != this.lenghtNumber);
    }
}
