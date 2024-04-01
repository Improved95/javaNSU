package org.lab3.model.objects;

public abstract class SlashBladeAbstractObject extends DrawObjectAbstract implements SlashBladeObject {
    protected double inGamePosX;
    protected double inGamePosY;

    @Override
    public double getInGamePosX() {
        return inGamePosX;
    }

    @Override
    public void setInGamePosX(double inGamePosX) {
        this.inGamePosX = inGamePosX;
    }

    @Override
    public double getInGamePosY() {
        return inGamePosY;
    }

    @Override
    public void setInGamePosY(double inGamePosY) {
        this.inGamePosY = inGamePosY;
    }

    @Override
    public void changeInGamePos(double dx, double dy) {
        this.inGamePosX += dx;
        this.inGamePosY += dy;
    }
}
