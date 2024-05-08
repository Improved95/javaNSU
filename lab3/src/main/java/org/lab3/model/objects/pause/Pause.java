package org.lab3.model.objects.pause;

import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.Constants;

public class Pause extends SlashBladeObjectAbstract {
    private PauseButton resume = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.RESUME_BUTTON_INDEX);
    private PauseButton reset = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.RESET_BUTTON_INDEX);
    private PauseButton exit = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.EXIT_BUTTON_INDEX);

    public Pause(FrameSize frameSize) {
        setWidth(Constants.PauseConstants.PAUSE_BG_WIDTH);
        setHeight(Constants.PauseConstants.PAUSE_BG_HEIGHT);
        setResourcesIndexInResourcesList(Constants.PauseConstants.PAUSE_ATLAS_INDEX);
        setScreenLayerLevel(10);
        setCurrentImageIndex(0, 0);
        setInGamePosition(frameSize.getWidth() / 2F - objectWidth / 2F, frameSize.getHeight() / 2F - objectHeight / 2F);
        setObjectSize(100);

        double buttonsPosX = inGamePosX + objectWidth / 2F - resume.getWidth() / 2F;
        resume.setInGamePosition(buttonsPosX, inGamePosY + objectHeight / 4F * 3 - resume.getHeight() / 2);
        reset.setInGamePosition(buttonsPosX, inGamePosY + objectHeight / 4F * 2 - reset.getHeight() / 2);
        exit.setInGamePosition(buttonsPosX, inGamePosY + objectHeight / 4F - exit.getHeight() / 2);

        setGameObjectIsExist(false);
    }

    public PauseButton getResume() {
        return resume;
    }

    public PauseButton getReset() {
        return reset;
    }

    public PauseButton getExit() {
        return exit;
    }

    @Override
    public void setGameObjectIsExist(boolean gameObjectIsExist) {
        this.gameObjectIsExist = gameObjectIsExist;
        resume.setGameObjectIsExist(gameObjectIsExist);
        reset.setGameObjectIsExist(gameObjectIsExist);
        exit.setGameObjectIsExist(gameObjectIsExist);
    }

}
