package org.lab3.model.model;

import org.lab3.model.gameObjectsContext.ObjectsContext;
import org.lab3.slashBlade.FrameSize;

public interface Model {
    FrameSize getFrameSize();

    void setFrameSize(FrameSize frameSize);

    String getCurrentGameMode();

    void setCurrentGameMode(String currentGameMode);

    ObjectsContext getGameModeObjectsContext();

    void setGameModeObjectsContext(ObjectsContext gameModeObjectsContext);
}
