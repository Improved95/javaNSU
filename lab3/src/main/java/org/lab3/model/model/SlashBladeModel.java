package org.lab3.model.model;

import org.lab3.model.gameObjectsContext.ObjectsContext;

public class SlashBladeModel implements Model {
    private String currentGameMode;
    private ObjectsContext gameModeObjectsContext;

    @Override
    public String getCurrentGameMode() {
        return currentGameMode;
    }

    @Override
    public void setCurrentGameMode(String currentGameMode) {
        this.currentGameMode = currentGameMode;
    }

    @Override
    public ObjectsContext getGameModeObjectsContext() {
        return gameModeObjectsContext;
    }

    @Override
    public void setGameModeObjectsContext(ObjectsContext gameModeObjectsContext) {
        this.gameModeObjectsContext = gameModeObjectsContext;
    }
}
