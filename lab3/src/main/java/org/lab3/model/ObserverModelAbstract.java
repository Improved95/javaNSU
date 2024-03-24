package org.lab3.model;

import org.lab3.observers.ControllerObservable;
import org.lab3.observers.ViewObserver;

import java.util.AbstractList;
import java.util.ArrayList;

public abstract class ObserverModelAbstract implements Model {
    AbstractList<ViewObserver> viewObservers = new ArrayList<>();

    @Override
    public void update() {}

    @Override
    public void registerObserver(ViewObserver o) {
        viewObservers.add(o);
    }

    @Override
    public void removeObserver(ViewObserver o) {
        viewObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (ViewObserver viewObserver : viewObservers) {
            viewObserver.update();
        }
    }
}
