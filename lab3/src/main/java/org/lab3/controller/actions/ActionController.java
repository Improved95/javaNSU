package org.lab3.controller.actions;

import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;

public interface ActionController {
    int nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                  double currentFPS, Model model);
    void initial();
}
