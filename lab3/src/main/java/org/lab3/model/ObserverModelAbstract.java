package org.lab3.model;

import org.lab3.observers.ViewObserver;
import org.lab3.slashBlade.JFrameObject;

import java.util.AbstractList;
import java.util.ArrayList;

public abstract class ObserverModelAbstract implements Model {
    protected AbstractList<ViewObserver> viewObservers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver o) {
        viewObservers.add(o);
    }

    @Override
    public void removeObserver(ViewObserver o) {
        viewObservers.remove(o);
    }

    @Override
    public void notifyObserversModifyDrawObjectList() {

    }

    @Override
    public void updateKeyPressStatus(int keyCode) {

    }

    @Override
    public void updateKeyReleaseStatus(int keyCode) {

    }

    @Override
    public void updateMouseKeyPressedStatus(int mouseKeyCode) {

    }
}
