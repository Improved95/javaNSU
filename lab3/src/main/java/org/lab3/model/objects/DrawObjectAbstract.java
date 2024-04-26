package org.lab3.model.objects;

import org.lab3.resources.ResourcesContext;

import java.awt.image.BufferedImage;

public abstract class DrawObjectAbstract implements DrawObject {
    protected double screenPosX;
    protected double screenPosY;
    protected double screenSize = 100;
    protected int screenHorizontalDirection = 1;
    protected boolean drawImageOnMiddle = false;
    protected int screenLayerLevel = 0;
    protected int screenWidth;
    protected int screenHeight;
    protected ResourcesContext resourcesContext;
    protected BufferedImage image;

    public DrawObjectAbstract(String atlas) {
        resourcesContext = new ResourcesContext();
        resourcesContext.addImage(atlas);
    }

    @Override
    public double getScreenPosX() {
        return screenPosX;
    }

    @Override
    public void setScreenPosX(double screenPosX) {
        this.screenPosX = screenPosX;
    }

    @Override
    public double getScreenPosY() {
        return screenPosY;
    }

    @Override
    public void setScreenPosY(double screenPosY) {
        this.screenPosY = screenPosY;
    }

    @Override
    public int getScreenHorizontalDirection() {
        return screenHorizontalDirection;
    }

    @Override
    public void setScreenHorizontalDirection(int screenHorizontalDirection) {
        this.screenHorizontalDirection = screenHorizontalDirection;
    }

    @Override
    public boolean isDrawImageOnMiddle() {
        return drawImageOnMiddle;
    }

    @Override
    public void setDrawImageOnMiddle(boolean drawImageOnMiddle) {
        this.drawImageOnMiddle = drawImageOnMiddle;
    }

    @Override
    public int getScreenLayerLevel() {
        return screenLayerLevel;
    }

    @Override
    public void setScreenLayerLevel(int screenLayerLevel) {
        this.screenLayerLevel = screenLayerLevel;
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public int getScreenWidth() {
        return screenWidth;
    }

    @Override
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    @Override
    public int getScreenHeight() {
        return screenHeight;
    }

    @Override
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
