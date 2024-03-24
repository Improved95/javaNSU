package org.lab3.controller;

import org.lab3.observers.ControllerObservable;

public interface Controller extends ControllerObservable {
    void readInput();
}
