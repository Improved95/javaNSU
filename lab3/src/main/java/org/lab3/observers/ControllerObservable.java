package org.lab3.observers;

public interface ControllerObservable {
    void registerObserver(ModelObserver o);
    void removeObserver(ModelObserver o);
    void notifyObserversPressKey(int keyCode);
    void notifyObserversReleaseKey(int keyCode);
    void notifyObserversMousePressed(int mouseKeyCode);
}
