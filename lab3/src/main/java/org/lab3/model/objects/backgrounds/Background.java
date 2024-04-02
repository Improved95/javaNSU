package org.lab3.model.objects.backgrounds;

import org.lab3.model.objects.SlashBladeObjectAbstract;

public class Background extends SlashBladeObjectAbstract {
    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
