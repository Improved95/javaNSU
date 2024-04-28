package org.lab3.controller.actions.pause;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.Constants;
import org.lab3.model.objects.pause.Pause;

import java.awt.*;

public class PauseAction implements ActionController {
    private Pause pauseLayout;
    private boolean isResumePress;
    private boolean isResetPress;
    private boolean isExitPress;

    public PauseAction(Pause pauseLayout) {
        this.pauseLayout = pauseLayout;
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

        Rectangle buttonHitbox = pauseLayout.getResume().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            System.out.println("resume press");
            isResumePress = true;
        }

        buttonHitbox = pauseLayout.getReset().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            System.out.println("reset press");
            isResetPress = true;
        }


        buttonHitbox = pauseLayout.getExit().getHitbox();
        if (buttonHitbox.contains(x, y)) {
            System.out.println("reset press");
            isExitPress = true;
        }
    }

    @Override
    public int nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                        double currentFPS, Model model) {

        if (isResumePress)
            return Constants.PauseConstants.RESUME_PRESS;
        if (isExitPress)
            return Constants.PauseConstants.RESET_PRESS;
        if (isExitPress)
            return Constants.PauseConstants.EXIT_PRESS;
        return Constants.PauseConstants.NOTHING_PRESS;
    }
}
