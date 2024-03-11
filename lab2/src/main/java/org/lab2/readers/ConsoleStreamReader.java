package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

import java.io.BufferedReader;
import java.util.Scanner;

public class ConsoleStreamReader implements InputDataReader {
    @Override
    public boolean read(ReturnInputArguments arguments) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        if (line.equals("exit")) { return false; }

        arguments.setArguments(line.split(" "));
        return true;
    }

    @Override
    public void close() throws Exception {}
}
