package org.lab3.model;

import org.lab3.controller.Controller;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ModelObservable;
import org.lab3.observers.ModelObserver;

public interface Model extends ModelObserver, ModelObservable {
    void change();
    GameMode getCurrentGameMode();
}
