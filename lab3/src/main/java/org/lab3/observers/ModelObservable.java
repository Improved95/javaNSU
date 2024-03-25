package org.lab3.observers;

import org.lab3.slashBlade.JFrameObject;

public interface ModelObservable {
    void registerObserver(ViewObserver o);
    void removeObserver(ViewObserver o);
    void notifyObservers(JFrameObject slashBladeJFrame);
}
