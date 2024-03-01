package org.lab2.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader implements FileParser {
    @Override
    public Map<String, String> parse(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Map<String, String> configMap = new HashMap<>();

        try {
            while ((line = br.readLine()) != null) {
                String args[] = line.split("=");
                configMap.put(args[0], args[1]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return configMap;
    }
}
