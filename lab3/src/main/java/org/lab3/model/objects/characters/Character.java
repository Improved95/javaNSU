package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;

public abstract class Character extends SlashBladeAbstractObject implements SlashBladeCharacter {
    protected int direction;
    protected double speedOfRun; // units per second
    protected boolean isRun;

    public Character() {
        setDrawImageOnMiddle(true);
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
    public void changeRunStatus(boolean isRun) {
        this.isRun = isRun;
    }

    @Override
    public void changeDirection(int direction) {
        this.direction = direction;
        setHorizontalDirection(direction);
    }

    @Override
    public void running2D(double currentFPS) {
        if (isRun) {
            inGamePosX += getValueByFPS(speedOfRun * this.direction, currentFPS);
        }
    }

    protected double getValueByFPS(double value, double FPS) {
        return value / FPS;
    }
}
