package org.lab3.observers;

import org.lab3.model.NeedDrawObject;

public interface ModelObservable {
    void registerObserver(ViewObserver o);
    void removeObserver(ViewObserver o);
    void notifyObserversAddDrawObject(NeedDrawObject drawObject);
    void notifyObserversRemoveDrawObject(NeedDrawObject drawObject);
}
