package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;

public abstract class Character extends SlashBladeAbstractObject {
    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
