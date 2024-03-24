package org.lab3.model;

import org.lab3.controller.Controller;
import org.lab3.observers.ViewObserver;

public abstract class ObserverModelAbstract implements Model {
    public ObserverModelAbstract(Controller controller) {
        controller.registerObserver(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void registerObserver(ViewObserver o) {

    }

    @Override
    public void removeObserver(ViewObserver o) {

    }

    @Override
    public void notifyObservers() {

    }
}
