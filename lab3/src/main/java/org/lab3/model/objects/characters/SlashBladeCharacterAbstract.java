package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeObjectAbstract;

public abstract class SlashBladeCharacterAbstract extends SlashBladeObjectAbstract implements SlashBladeCharacter {
    protected CharacterParametersContext parametersContext;

    public SlashBladeCharacterAbstract(String atlas) {
        super(atlas);
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

    @Override
    public void attack() {

    }
}
