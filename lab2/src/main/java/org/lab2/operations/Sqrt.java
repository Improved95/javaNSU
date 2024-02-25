package org.lab2.operations;

class Sqrt implements Operation {
    @Override
    public double performSingleOperation(double a) {
        return Math.sqrt(a);
    }
}
