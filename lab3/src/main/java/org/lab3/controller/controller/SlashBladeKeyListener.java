package org.lab3.controller.controller;

import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.LogicController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class SlashBladeKeyListener implements KeyListenerController {
    private FrameSize frameSize;
    private KeysIsPressedContext keysIsPressedContext = new KeysIsPressedContext();

    private LogicController logicController;

    public SlashBladeKeyListener(LogicController logicController) {
        this.logicController = logicController;
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 0) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 1);
            logicController.keyPressedObserver(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keysIsPressedContext.getKeyStatus(e.getKeyCode()) == 1) {
            keysIsPressedContext.setKeyStatus(e.getKeyCode(), 0);
            logicController.keyReleasedObserver(e.getKeyCode());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int newPosY = e.getY() - frameSize.getInsets().top;
        logicController.mousePressedObserver(e.getButton(), e.getX(), newPosY);
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
