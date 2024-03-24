package org.lab3.controller;

import org.lab3.observers.ControllerObservable;
import org.lab3.slashBlade.JFrameObject;

import java.awt.event.KeyListener;

public interface Controller extends ControllerObservable, KeyListener {
    void readInput(JFrameObject jFrameObject);
}
