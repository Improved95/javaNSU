package org.lab3.controller;

import java.awt.event.KeyEvent;

public class SlashBladeController extends ObserverControllerAbstract {
    KeysIsPressedContext keysIsPressedContext = new KeysIsPressedContext();

    public KeysIsPressedContext getKeysIsPressedContext() {
        return keysIsPressedContext;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 0) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 1);
            System.out.println("keyPressed " + e.getKeyChar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 1) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 0);
            System.out.println("keyReleased " + e.getKeyChar());
        }
    }
}
