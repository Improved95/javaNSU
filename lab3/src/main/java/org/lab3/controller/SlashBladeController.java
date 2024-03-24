package org.lab3.controller;

import org.lab3.slashBlade.JFrameObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SlashBladeController extends ObserverControllerAbstract {
    KeysIsPressedContext keysIsPressedContext = new KeysIsPressedContext();

    public KeysIsPressedContext getKeysIsPressedContext() {
        return keysIsPressedContext;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased " + e.getKeyCode());
    }

    @Override
    public void readInput(JFrameObject jFrameObject) {
        if (false) {
            notifyObservers();
        }
    }
}
