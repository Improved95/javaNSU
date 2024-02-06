package org.lab1;

public class BullsAndCows {
    BullsAndCows() {}

    private String hiddenNumber = "";
    
    private void generateNumber() {
        for (int i = 0; i < quantityNumber; i++) {
            Integer number;
            do {
                number = (int)(Math.random() * 10);
            } while(hiddenNumber.contains(number.toString()));
            hiddenNumber += number;
        }
    }


    private final int quantityNumber = 4;

    public void initialBoolsAndCows() {
        generateNumber();
    }
}
