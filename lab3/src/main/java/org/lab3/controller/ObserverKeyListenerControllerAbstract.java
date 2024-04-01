package org.lab3.controller;

import org.lab3.observers.ModelObserver;

import java.util.AbstractList;
import java.util.ArrayList;

public abstract class ObserverKeyListenerControllerAbstract implements KeyListenerController {
    protected AbstractList<ModelObserver> modelObservers = new ArrayList<>();

    @Override
    public void registerObserver(ModelObserver o) {
        modelObservers.add(o);
    }

    @Override
    public void removeObserver(ModelObserver o) {
        modelObservers.remove(o);
    }

    @Override
    public void notifyObserversPressKey(int keyCode) {

    }

    @Override
    public void notifyObserversReleaseKey(int keyCode) {

    }
}
