package org.lab2.readers;

import org.lab2.Calculator.ReturnInputArguments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileStreamReader implements InputReader {
    private BufferedReader br;

    public FileStreamReader(String filePath) {
        br = new BufferedReader(new FileInputStream(filePath));
    }

    @Override
    public boolean read(ReturnInputArguments arguments) {
        return false;
    }

    //    public boolean parse(ReturnInputArguments arguments) {
//        String line;
//        try {
//            if ((line = br.readLine()) == null) {
//                return false;
//            }
//        } catch (java.io.IOException ex) {
//            return false;
//        }
//
//        arguments.setArguments(line.split(" "));
//        return true;
//    }
}
