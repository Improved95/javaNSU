package org.lab3.model.objects.backgrounds;

import org.lab3.model.Constants;
import org.lab3.model.objects.SlashBladeObjectAbstract;

public class Background extends SlashBladeObjectAbstract {
    public Background() {
        setWidth(Constants.BackgroundConstants.BACKGROUND_WIDTH);
        setHeight(Constants.BackgroundConstants.BACKGROUND_HEIGHT);
    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
