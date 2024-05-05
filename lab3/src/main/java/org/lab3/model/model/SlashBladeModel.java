package org.lab3.model.model;

import org.lab3.controller.gameMode.GameState;
import org.lab3.model.gameObjectsContext.ObjectsContext;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeModel implements Model {
    private FrameSize frameSize;
    private GameState gameState;
    private ObjectsContext gameModeObjectsContext;

    @Override
    public FrameSize getFrameSize() {
        return frameSize;
    }

    @Override
    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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
