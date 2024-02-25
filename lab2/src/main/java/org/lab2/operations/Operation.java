package org.lab2.operations;

public interface Operation {
    default double performBinaryOperation(double a, double b) { return 0; }
    default double performSingleOperation(double a) { return a; }

}
