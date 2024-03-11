package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

import java.io.*;

public class FileStreamReader implements InputDataReader {
    private BufferedReader br;

    public FileStreamReader(String filePath) throws IOException {
        this.br = openReader(filePath);
    }

    @Override
    public boolean read(ReturnInputArguments arguments) {
        String line;
        try {
            if ((line = br.readLine()) == null) {
                return false;
            }
        } catch (java.io.IOException ex) {
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

    private BufferedReader openReader(String filePath) throws IOException {
        FileReader fileInputReader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fileInputReader);
        return br;
    }
}
