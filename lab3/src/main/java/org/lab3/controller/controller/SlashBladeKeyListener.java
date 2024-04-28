package org.lab3.controller.controller;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

class SlashBladeKeyListener implements KeyListenerController {
    KeysIsPressedContext keysIsPressedContext = new KeysIsPressedContext();

    SlashBladeLogicController slashBladeLogicController;

    SlashBladeKeyListener(SlashBladeLogicController slashBladeLogicController) {
        this.slashBladeLogicController = slashBladeLogicController;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 0) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 1);
            slashBladeLogicController.keyPressedObserver(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 1) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 0);
            slashBladeLogicController.keyReleasedObserver(e.getKeyCode());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        slashBladeLogicController.mousePressedObserver(e.getButton(), e.getX(), e.getY());
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
}

class KeysIsPressedContext {
    Map<Integer, KeyStatus> keysStatusMap = new HashMap<>();

    KeysIsPressedContext() {
        keysStatusMap.put(87, new KeyStatus()); // w
        keysStatusMap.put(65, new KeyStatus()); // a
        keysStatusMap.put(83, new KeyStatus()); // s
        keysStatusMap.put(68, new KeyStatus()); // d
        keysStatusMap.put(32, new KeyStatus()); // space
        keysStatusMap.put(27, new KeyStatus()); // escape
    }

    public int getKeyStatus(int keyCode) {
        if (keysStatusMap.containsKey(keyCode)) {
            return keysStatusMap.get(keyCode).status;
        }
        return -1;
    }

    public void setKeyStatus(int keyCode, int keyStatus) {
        if (keysStatusMap.containsKey(keyCode)) {
            keysStatusMap.get(keyCode).status = keyStatus;
        }
    }

    private class KeyStatus {
        public int status = 0;
    }
}
