package org.lab3.model;

import org.lab3.observers.ViewObserver;
import org.lab3.slashBlade.JFrameObject;

import java.util.AbstractList;
import java.util.ArrayList;

public abstract class ObserverModelAbstract implements Model {
    AbstractList<ViewObserver> viewObservers = new ArrayList<>();

    @Override
    public void update(JFrameObject slashBladeJFrame) {}

    @Override
    public void registerObserver(ViewObserver o) {
        viewObservers.add(o);
    }

    @Override
    public void removeObserver(ViewObserver o) {
        viewObservers.remove(o);
    }

    @Override
    public void notifyObservers(JFrameObject slashBladeJFrame) {}
}
