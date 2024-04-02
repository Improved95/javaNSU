package org.lab3.model.model;

import org.lab3.model.gameObjectsContext.ObjectsContext;

public class SlashBladeModel implements Model {
    private String currentGameMode;
    private ObjectsContext gameModeObjectscontext;

    @Override
    public String getCurrentGameMode() {
        return currentGameMode;
    }

    @Override
    public void setCurrentGameMode(String currentGameMode) {
        this.currentGameMode = currentGameMode;
    }

    @Override
    public ObjectsContext getGameModeObjectscontext() {
        return gameModeObjectscontext;
    }

    @Override
    public void setGameModeObjectscontext(ObjectsContext gameModeObjectscontext) {
        this.gameModeObjectscontext = gameModeObjectscontext;
    }
}
