package org.lab2.exceptions;

public abstract class MyExceptions extends Exception {
    public MyExceptions(String msg) {
        this.msg = msg;
    }

    private String msg;

    public void PrintInfo() {
        System.err.println(msg);
    }
}
