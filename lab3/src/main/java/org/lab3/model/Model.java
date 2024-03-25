package org.lab3.model;

import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ModelObservable;
import org.lab3.observers.ModelObserver;
import org.lab3.slashBlade.JFrameObject;

public interface Model extends ModelObserver, ModelObservable {
    void changeModel(JFrameObject slashBladeJFrame);
    GameMode getCurrentGameMode();
}
