package org.lab3.observers;

public interface ModelObserver {
    void updateKeyPressStatus(int keyCode);
    void updateKeyReleaseStatus(int keyCode);
    void updateMouseKeyPressedStatus(int mouseKeyCode);
}
