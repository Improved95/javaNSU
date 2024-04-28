package org.lab3.model.objects;
import java.awt.*;

public abstract class SlashBladeObjectAbstract extends DrawObjectAbstract implements SlashBladeObject {
    protected double inGamePosX;
    protected double inGamePosY;
    protected int objectWidth;
    protected int objectHeight;
    protected int inGameHorizontalDirection;
    protected boolean gameObjectIsExist = true;
    protected double currentSpeedX;
    protected double currentSpeedY;
    protected Rectangle hitbox = new Rectangle();

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
        this.hitbox.setLocation((int)x, (int)y);
    }

    @Override
    public void changeInGamePosition(double dx, double dy) {
        this.inGamePosX += dx;
        this.inGamePosY += dy;
        this.hitbox.setLocation((int)(hitbox.getX() + dx), (int)(hitbox.getY() + dy));
    }

    @Override
    public int getWidth() {
        return objectWidth;
    }

    @Override
    public int getHeight() {
        return objectHeight;
    }

    @Override
    public int getInGameHorizontalDirection() {
        return inGameHorizontalDirection;
    }

    @Override
    public void setInGameHorizontalDirection(int inGameHorizontalDirection) {
        this.inGameHorizontalDirection = inGameHorizontalDirection;
    }

    @Override
    public void changeDirection(int direction) {
        setInGameHorizontalDirection(direction);
        setScreenHorizontalDirection(direction);
    }


    @Override
    public double getObjectSize() {
        return screenSize;
    }

    @Override
    public void setObjectSize(double screenSize) {
        double newSize = screenSize / 100;
        setWidth((int)(objectWidth * newSize));
        setHeight((int)(objectHeight * newSize));

        setScreenWidth(objectWidth);
        setScreenHeight(objectHeight);

        this.screenSize = screenSize;
    }

    @Override
    public void setWidth(int objectWidth) {
        this.objectWidth = objectWidth;
        this.hitbox.setSize(objectWidth, objectHeight);
    }

    @Override
    public void setHeight(int objectHeight) {
        this.objectHeight = objectHeight;
        this.hitbox.setSize(objectWidth, objectHeight);
    }

    @Override
    public boolean isGameObjectIsExist() {
        return gameObjectIsExist;
    }

    @Override
    public void setGameObjectIsExist(boolean gameObjectIsExist) {
        this.gameObjectIsExist = gameObjectIsExist;
    }

    @Override
    public double getCurrentSpeedX() {
        return currentSpeedX;
    }

    @Override
    public void setCurrentSpeedX(double currentSpeedX) {
        this.currentSpeedX = currentSpeedX;
    }

    @Override
    public double getCurrentSpeedY() {
        return currentSpeedY;
    }

    @Override
    public void setCurrentSpeedY(double currentSpeedY) {
        this.currentSpeedY = currentSpeedY;
    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
