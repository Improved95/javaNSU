package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeObjectAbstract;

import java.awt.*;

public abstract class SlashBladeCharacterAbstract extends SlashBladeObjectAbstract implements SlashBladeCharacter {
    protected CharacterParametersContext parametersContext;
    protected Rectangle attackHitbox;

    public SlashBladeCharacterAbstract() {
        this.parametersContext = new CharacterParametersContext();
    }

    @Override
    public CharacterParametersContext getParametersContext() {
        return parametersContext;
    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }

    @Override
    public void moveX(double dx) {
        changeInGamePos(dx, 0);
    }

    @Override
    public void moveY(double dy) {
        changeInGamePos(0, dy);
    }
}
