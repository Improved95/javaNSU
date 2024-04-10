package org.lab3.controller.actions;

import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.slashBlade.FrameSize;

public interface ActionController {
    void setExecuteStatus(boolean isExecute);

    void setBlockExecuteStatus(boolean isBlockExecute);

    void execute(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext, double currentFPS, FrameSize frameSize);
}
