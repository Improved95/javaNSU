package org.lab3.model.objects;

import org.lab3.model.NeedDrawObjectAbstract;

public class SlashBladeAbstractObject extends NeedDrawObjectAbstract {
    protected int inGamePosX;
    protected int inGamePosY;

    @Override
    public void setInGamePosition(int x, int y) {
        this.inGamePosX = x;
        this.inGamePosY = y;
    }

    @Override
    public void changeInGamePosition(int x, int y) {
        this.inGamePosX += x;
        this.inGamePosY += y;
    }

    @Override
    public int getInGamePosX() {
        return inGamePosX;
    }

    @Override
    public int getInGamePosY() {
        return inGamePosY;
    }
}
