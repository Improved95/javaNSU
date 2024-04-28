package org.lab3.controller.actions.pause;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.Constants;
import org.lab3.model.objects.pause.EndGamePause;

import java.awt.*;

public class EndGameMenuAction implements ActionController {
    private EndGamePause layout;
    private boolean isResetPress;
    private boolean isExitPress;

    public EndGameMenuAction(EndGamePause layout) {
        this.layout = layout;
    }

    @Override
    public void initial() {
        isResetPress = false;
        isExitPress = false;
    }

    public void mousePressed(int x, int y) {
        isResetPress = false;
        isExitPress = false;

        System.out.println("End game " + x + " " + y);

        Rectangle buttonHitbox = layout.getReset().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            isResetPress = true;
        }
        System.out.println(buttonHitbox.x + " " + buttonHitbox.y);

        buttonHitbox = layout.getExit().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            isExitPress = true;
        }
    }

    @Override
    public int nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                        double currentFPS, Model model) {

        if (isResetPress)
            return Constants.GameConstants.RESET;
        if (isExitPress)
            return Constants.GameConstants.EXIT_GAME;

        return Constants.GameConstants.NOTHING_DOING;
    }
}
