package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputParser {
    BufferedReader br;

    public InputParser(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    public boolean parse(ReturnInputArguments arguments) {
        String line;
        try {
            if ((line = br.readLine()) == null) {
                return false;
            }
        } catch (java.io.IOException ex) {
            return false;
        }

        arguments.setArguments(line.split(" "));
        return true;
    }
}
