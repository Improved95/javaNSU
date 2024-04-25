package org.lab3.model.model;

import org.lab3.model.gameObjectsContext.ObjectsContext;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeModel implements Model {
    private FrameSize frameSize;
    private String currentGameMode;
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
