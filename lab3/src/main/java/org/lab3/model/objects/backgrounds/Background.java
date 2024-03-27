package org.lab3.model.objects.backgrounds;

import org.lab3.model.objects.SlashBladeAbstractObject;

public class Background extends SlashBladeAbstractObject {
    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
