package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;
import org.lab3.controller.characterMovement.CharacterParametersContext;

public abstract class SlashBladeCharacterAbstract extends SlashBladeAbstractObject implements SlashBladeCharacter {
    protected CharacterParametersContext parametersContext = new CharacterParametersContext();

    public SlashBladeCharacterAbstract() {
        setDrawImageOnMiddle(true);
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

    @Override
    public void changeDirection(int direction) {
        parametersContext.setInGameHorizontalDirection(direction);
        setScreenHorizontalDirection(direction);
    }
}
