package org.lab3.observers;

public interface ControllerObservable {
    void registerObserver(ModelObserver o);
    void removeObserver(ModelObserver o);
    void notifyObservers();
}
