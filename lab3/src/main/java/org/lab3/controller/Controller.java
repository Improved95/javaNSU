package org.lab3.controller;

import org.lab3.observers.ControllerObservable;
import org.lab3.slashBlade.JFrameObject;

public interface Controller extends ControllerObservable {
    void readInput(JFrameObject jFrameObject);
}
