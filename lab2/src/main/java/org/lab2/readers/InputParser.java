package org.lab2.readers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class InputParser implements FileParser {
    BufferedReader br;

    public InputParser(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public Map<String, String[]> parse(InputStream inputStream) {
        return null;
    }
}
