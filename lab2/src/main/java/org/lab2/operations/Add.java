package org.lab2.operations;

class Add implements Operation {
    @Override
    public double performBinaryOperation(double a, double b) {
        return a + b;
    }
}
