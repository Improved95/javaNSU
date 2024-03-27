package org.lab3.model.objects;

import org.lab3.model.NeedDrawObjectAbstract;

public abstract class SlashBladeAbstractObject extends NeedDrawObjectAbstract {
    protected double inGamePosX;
    protected double inGamePosY;

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
}
