package org.lab3.observers;

public interface ModelObservable {
    void registerObserver(ViewObserver o);
    void removeObserver(ViewObserver o);
    void notifyObserversModifyDrawObjectList();
}
