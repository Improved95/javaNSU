package org.lab3.view;

import org.lab3.observers.ModelObservable;

public abstract class ViewObserverAbstract implements View {
    public ViewObserverAbstract(ModelObservable model) {
        model.registerObserver(this);
    }

    @Override
    public void update() {}
}
