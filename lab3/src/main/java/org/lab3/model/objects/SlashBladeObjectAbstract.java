package org.lab3.model.objects;

public abstract class SlashBladeObjectAbstract extends DrawObjectAbstract implements SlashBladeObject {
    protected double inGamePosX;
    protected double inGamePosY;
    protected int width;
    protected int height;
    protected boolean gameObjectIsExist = true;

    public SlashBladeObjectAbstract() {
        setObjectSize(100);
    }

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
    public void setInGamePosition(double x, double y) {
        this.inGamePosX = x;
        this.inGamePosY = y;
    }

    @Override
    public void changeInGamePos(double dx, double dy) {
        this.inGamePosX += dx;
        this.inGamePosY += dy;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getObjectSize() {
        return screenSize;
    }

    @Override
    public void setObjectSize(double screenSize) {
        double newSize = screenSize / 100;
        width = (int)(width * newSize);
        height = (int)(height * newSize);

        setScreenWidth(width * getScreenHorizontalDirection() * getScreenHorizontalDirection());
        setScreenHeight(height);

        this.screenSize = screenSize;
    }

    @Override
    public boolean isGameObjectIsExist() {
        return gameObjectIsExist;
    }

    @Override
    public void setGameObjectIsExist(boolean gameObjectIsExist) {
        this.gameObjectIsExist = gameObjectIsExist;
    }
}
