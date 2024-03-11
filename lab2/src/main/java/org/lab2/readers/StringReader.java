package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

import java.io.*;

public class StringReader implements InputDataReader {
    private BufferedReader br;

    public StringReader(String commandsSet) {
        InputStream inputStream = new ByteArrayInputStream(commandsSet.getBytes());
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public boolean read(ReturnInputArguments arguments) {
        String line;
        try {
            if ((line = br.readLine()) == null) {
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        arguments.setArguments(line.split(" "));
        return true;
    }

    @Override
    public void close() throws Exception {
        br.close();
    }
}
