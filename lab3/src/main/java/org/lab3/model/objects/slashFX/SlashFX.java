package org.lab3.model.objects.slashFX;

import org.lab3.model.Constants;
import org.lab3.model.objects.SlashBladeObjectAbstract;

public class SlashFX extends SlashBladeObjectAbstract {
    public SlashFX() {
        setWidth(Constants.FXConstants.SLASH_FX_WIDTH);
        setHeight(Constants.FXConstants.SLASH_FX_HEIGHT);
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
