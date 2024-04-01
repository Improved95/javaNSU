package org.lab3.observers;

import org.lab3.model.objects.DrawObject;

public interface ModelObservable {
    void registerObserver(ViewObserver o);
    void removeObserver(ViewObserver o);
    void notifyObserversAddDrawObject(DrawObject drawObject);
    void notifyObserversRemoveDrawObject(DrawObject drawObject);
}
