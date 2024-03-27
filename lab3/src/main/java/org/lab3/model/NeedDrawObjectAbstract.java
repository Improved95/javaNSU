package org.lab3.model;

import org.lab3.model.objects.SlashBladeObject;

public abstract class NeedDrawObjectAbstract implements NeedDrawObject, SlashBladeObject {
    private double screenPosX;
    private double screenPosY;
    private double screenSize;
    private int horizontalDirection = 1;
    private boolean drawImageOnMiddle = false;
    private int screenLayerLevel = 0;
    private VisualContext visualContext;

    public NeedDrawObjectAbstract() {
        this.visualContext = new VisualContext();
    }

    @Override
    public double getScreenPosX() {
        return screenPosX;
    }

    @Override
    public double getScreenPosY() {
        return screenPosY;
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
    public void setScreenSize(double size) {
        this.screenSize = size;
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public void setDrawImageOnMiddle(boolean drawImageOnMiddle) {
        this.drawImageOnMiddle = drawImageOnMiddle;
    }

    @Override
    public boolean isDrawImageOnMiddle() {
        return drawImageOnMiddle;
    }

    @Override
    public void setScreenLayerLevel(int screenLayerLevel) {
        this.screenLayerLevel = screenLayerLevel;
    }

    @Override
    public int getScreenLayerLevel() {
        return screenLayerLevel;
    }

    @Override
    public VisualContext getVisualContext() {
        return visualContext;
    }
}
