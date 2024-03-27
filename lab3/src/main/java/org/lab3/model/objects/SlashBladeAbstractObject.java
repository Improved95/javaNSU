package org.lab3.model.objects;

import org.lab3.model.NeedDrawObjectAbstract;
import org.lab3.model.objects.characters.SlashBladeCharacter;

public abstract class SlashBladeAbstractObject extends NeedDrawObjectAbstract implements SlashBladeCharacter {
    protected double inGamePosX;
    protected double inGamePosY;

    protected int direction;
    protected double speedOfRun; // units per second
    protected boolean isRun;

    public SlashBladeAbstractObject() {
        this.setScreenSize(100);
    }

    @Override
    public void setInGamePosition(double x, double y) {
        this.inGamePosX = x;
        this.inGamePosY = y;
    }

    @Override
    public void changeInGamePosition(double x, double y) {
        this.inGamePosX += x;
        this.inGamePosY += y;
    }

    @Override
    public double getInGamePosX() {
        return inGamePosX;
    }

    @Override
    public double getInGamePosY() {
        return inGamePosY;
    }

    protected double getValueByFPS(double value, double FPS) {
        return value / FPS;
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
}
