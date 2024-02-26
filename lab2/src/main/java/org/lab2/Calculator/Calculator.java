package org.lab2.Calculator;

import org.lab2.operations.Operation;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Calculator {
    public void initialCalculator() {
        calculatorExecution();
    }

    private void calculatorExecution() {
        try {
            String urlPath = "src/main/java/org/lab2/operations/";
            URL classUrl = new URL(urlPath);
//            URL[] classUrls = { classUrl };

            /*ClassLoader classLoader = new URLClassLoader(classUrls);
            Class<?> add = classLoader.loadClass("Add");

            System.out.println(add.getName());*/

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/



    }
}
