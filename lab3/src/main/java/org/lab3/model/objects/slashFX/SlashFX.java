package org.lab3.model.objects.slashFX;

import org.lab3.model.objects.SlashBladeObjectAbstract;

public class SlashFX extends SlashBladeObjectAbstract {
    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
