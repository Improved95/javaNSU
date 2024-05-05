package org.lab3.controller.actions.pause;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.Constants;
import org.lab3.model.objects.pause.Pause;

import java.awt.*;

public class PauseAction implements ActionController {
    private Pause layout;
    private boolean isResumePress;
    private boolean isResetPress;
    private boolean isExitPress;

    public PauseAction(Pause layout) {
        this.layout = layout;
    }

    @Override
    public void initial() {
        isResumePress = false;
        isResetPress = false;
        isExitPress = false;
    }

    public void mousePressed(int x, int y) {
        isResumePress = false;
        isResetPress = false;
        isExitPress = false;

        Rectangle buttonHitbox = layout.getResume().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            isResumePress = true;
        }

        buttonHitbox = layout.getReset().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            isResetPress = true;
        }


        buttonHitbox = layout.getExit().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            isExitPress = true;
        }
    }

    @Override
    public int nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                        double currentFPS, Model model) {

        if (isResumePress)
            return Constants.GameConstants.REMOVE_FROM_PAUSE;
        if (isResetPress)
            return Constants.GameConstants.RESET;
        if (isExitPress)
            return Constants.GameConstants.EXIT_GAME;

        return Constants.GameConstants.NOTHING_DOING;
    }
}
