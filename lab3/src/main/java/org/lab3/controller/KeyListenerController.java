package org.lab3.controller;

import org.lab3.observers.ControllerObservable;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface KeyListenerController extends ControllerObservable, KeyListener, MouseListener {

}
