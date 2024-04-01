package org.lab3.model.model;

import org.lab3.controller.gameMode.GameMode;

public interface Model {
    GameMode getCurrentGameMode();

    void setCurrentGameMode(GameMode currentGameMode);
}
