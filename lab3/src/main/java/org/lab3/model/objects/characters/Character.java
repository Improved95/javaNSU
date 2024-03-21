package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;

public abstract class Character extends SlashBladeAbstractObject {
    public Character() {
        setInGamePosition(100, 0);
        setScreenSize(30);
    }

    @Override
    public int getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public int getScreenPosY() {
        return inGamePosY;
    }
}
