package org.lab2.operations;

public class Add implements Operation {
    @Override
    public double performBinaryOperation(double a, double b) {
        return a + b;
    }
}
