package org.lab2.readers;

import org.lab2.Calculator.Calculator;
import org.lab2.Calculator.InputArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileStreamReaderCalculator implements CalculatorInputDataReader {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);
    private BufferedReader br;

    public FileStreamReaderCalculator(String filePath) throws IOException {
        this.br = openReader(filePath);
    }

    @Override
    public boolean read(InputArguments arguments) {
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
        log.info("Read one string from input file: {}", line);
        return true;
    }

    @Override
    public void close() throws Exception {
        log.info("close input stream");
        br.close();
    }

    private BufferedReader openReader(String filePath) throws IOException {
        FileReader fileInputReader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fileInputReader);
        return br;
    }
}
