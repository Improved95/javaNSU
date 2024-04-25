package org.lab3.controller.actions;

import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;

public interface ActionController {
    void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                  double currentFPS, Model model);
}
