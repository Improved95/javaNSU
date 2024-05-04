package org.lab3.model.model;

import org.lab3.controller.gameMode.GameState;
import org.lab3.model.gameObjectsContext.ObjectsContext;
import org.lab3.model.objects.characters.slashBlade.FrameSize;

public interface Model {
    FrameSize getFrameSize();

    void setFrameSize(FrameSize frameSize);

    GameState getGameState();

    void setGameState(GameState gameState);

    ObjectsContext getGameModeObjectsContext();

    void setGameModeObjectsContext(ObjectsContext gameModeObjectsContext);
}
