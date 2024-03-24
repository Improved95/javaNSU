package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;

public abstract class Character extends SlashBladeAbstractObject {
    @Override
    public int getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public int getScreenPosY() {
        return inGamePosY;
    }
}
