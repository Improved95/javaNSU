package org.lab2.exceptions;

public abstract class MyExceptions extends Exception {
    private String msg;

    public MyExceptions(String msg) {
        this.msg = msg;
    }

    public void PrintInfo() {
        System.err.println(msg);
    }
}
