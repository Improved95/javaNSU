package org.lab3.model.objects.pause;

import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.Constants;

public class Pause extends SlashBladeObjectAbstract {
    private PauseButton resume = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.RESUME_BUTTON_INDEX);
    private PauseButton reset = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.RESET_BUTTON_INDEX);
    private PauseButton exit = new PauseButton(Constants.PauseConstants.BUTTONS_INDEX, Constants.PauseConstants.EXIT_BUTTON_INDEX);

    public Pause(FrameSize frameSize) {
        setWidth(Constants.PauseConstants.PAUSE_BG_WIDTH);
        setHeight(Constants.PauseConstants.PAUSE_BG_WIDTH);
        setResourcesIndexInResourcesList(Constants.PauseConstants.PAUSE_FX_ATLAS_INDEX);
        setScreenLayerLevel(10);
        setCurrentImageIndex(0, 0);
        setInGamePosition(frameSize.getWidth() / 2 - objectWidth / 2, frameSize.getHeight() / 2 - objectHeight / 2);

        resume.setInGamePosition(inGamePosX / 2 - resume.getWidth() / 2, inGamePosY / 4 - resume.getHeight() / 2);
        reset.setInGamePosition(inGamePosX / 2 - resume.getWidth() / 2, inGamePosY / 4 * 2 - resume.getHeight() / 2);
        exit.setInGamePosition(inGamePosX / 2 - resume.getWidth() / 2, inGamePosY / 4  * 3 - resume.getHeight() / 2);

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
