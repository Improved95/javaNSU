package org.lab3.model;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.observers.ModelObservable;
import org.lab3.observers.ModelObserver;
import org.lab3.slashBlade.FrameSize;

public interface Model extends ModelObserver, ModelObservable {
    void changeModel(double currentFPS, FrameSize frameSize);
    void initial();
    GameMode getCurrentGameMode();
}
