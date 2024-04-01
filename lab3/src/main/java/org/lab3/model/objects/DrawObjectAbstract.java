package org.lab3.model.objects;

import java.awt.image.BufferedImage;

public class DrawObjectAbstract implements DrawObject {
    protected double screenPosX;
    protected double screenPosY;
    protected double screenSize = 100;
    protected int horizontalDirection = 1;
    protected boolean drawImageOnMiddle = false;
    protected int screenLayerLevel = 0;
    protected BufferedImage image;

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
    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public int getHorizontalDirection() {
        return horizontalDirection;
    }

    @Override
    public void setHorizontalDirection(int horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
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
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
