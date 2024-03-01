package org.lab2.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class ConfigReader {
    public ConfigReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Map<String, String> getConfigMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Map<String, String> configMap = new HashMap<String, String>();
        while ((line = br.readLine()) != null) {
            String args[] = line.split("=");
            configMap.put(args[0], args[1]);
        }

        return configMap;
    }

    private InputStream inputStream;

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
