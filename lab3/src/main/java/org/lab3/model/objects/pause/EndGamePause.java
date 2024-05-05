package org.lab3.model.objects.pause;

import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.Constants;

public class EndGamePause extends SlashBladeObjectAbstract {
    private PauseButton reset = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.RESET_BUTTON_INDEX);
    private PauseButton exit = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.EXIT_BUTTON_INDEX);

    public EndGamePause(FrameSize frameSize) {
        setWidth(Constants.PauseConstants.PAUSE_BG_WIDTH);
        setHeight(Constants.PauseConstants.PAUSE_BG_HEIGHT);
        setResourcesIndexInResourcesList(Constants.PauseConstants.PAUSE_ATLAS_INDEX);
        setScreenLayerLevel(10);
        setCurrentImageIndex(0, 0);
        setInGamePosition(frameSize.getWidth() / 2F - objectWidth / 2F, frameSize.getHeight() / 2F - objectHeight / 2F);
        setObjectSize(100);

        double buttonsPosX = inGamePosX + objectWidth / 2F - reset.getWidth() / 2F;
        reset.setInGamePosition(buttonsPosX, inGamePosY + objectHeight / 3F - reset.getHeight() / 2);
        exit.setInGamePosition(buttonsPosX, inGamePosY + objectHeight / 3F * 2 - exit.getHeight() / 2);

        setGameObjectIsExist(false);
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
        reset.setGameObjectIsExist(gameObjectIsExist);
        exit.setGameObjectIsExist(gameObjectIsExist);
    }
}
