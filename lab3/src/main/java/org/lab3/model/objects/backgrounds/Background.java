package org.lab3.model.objects.backgrounds;

import org.lab3.slashBlade.Constants;
import org.lab3.model.objects.SlashBladeObjectAbstract;

public class Background extends SlashBladeObjectAbstract {
    public Background() {
        setWidth(Constants.BackgroundConstants.BACKGROUND_WIDTH);
        setHeight(Constants.BackgroundConstants.BACKGROUND_HEIGHT);
        setResourcesIndexInResourcesList(Constants.BackgroundConstants.BACKGROUND_ATLAS_INDEX);
        setCurrentImageIndex(0, 0);
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
