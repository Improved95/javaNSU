package org.lab3.controller;

import org.lab3.observers.ModelObserver;

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
            notifyObserversPressKey(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 1) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 0);
            notifyObserversReleaseKey(e.getKeyCode());
        }
    }

    @Override
    public void notifyObserversPressKey(int keyCode) {
        for (ModelObserver observer : modelObservers) {
            observer.updateKeyPressStatus(keyCode);
        }
    }

    @Override
    public void notifyObserversReleaseKey(int keyCode) {
        for (ModelObserver observer : modelObservers) {
            observer.updateKeyReleaseStatus(keyCode);
        }
    }
}
