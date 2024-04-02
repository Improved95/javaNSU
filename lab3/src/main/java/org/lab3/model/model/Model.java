package org.lab3.model.model;

import org.lab3.model.gameObjectsContext.ObjectsContext;

public interface Model {
    String getCurrentGameMode();

    void setCurrentGameMode(String currentGameMode);

    ObjectsContext getGameModeObjectsContext();

    void setGameModeObjectsContext(ObjectsContext gameModeObjectsContext);
}
