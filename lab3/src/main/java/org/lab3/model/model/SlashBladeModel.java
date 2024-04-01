package org.lab3.model.model;

import org.lab3.controller.gameMode.GameMode;

public class SlashBladeModel implements Model {
    private GameMode currentGameMode;

    @Override
    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    @Override
    public void setCurrentGameMode(GameMode currentGameMode) {
        this.currentGameMode = currentGameMode;
    }
}
