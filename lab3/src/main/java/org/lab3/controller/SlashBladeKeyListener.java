package org.lab3.controller;

import org.lab3.observers.ModelObserver;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SlashBladeKeyListener extends ObserverKeyListenerControllerAbstract {
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
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        notifyObserversMousePressed(e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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

    @Override
    public void notifyObserversMousePressed(int mouseKeyCode) {
        for (ModelObserver observer : modelObservers) {
            observer.updateMouseKeyPressedStatus(mouseKeyCode);
        }
    }
}
