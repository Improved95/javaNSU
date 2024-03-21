package org.lab3.model;

import org.lab3.model.objects.SlashBladeObject;

public abstract class NeedDrawObjectAbstractClass implements NeedDrawObject, SlashBladeObject {
    private int screenPosX;
    private int screenPosY;
    private int screenSize;
    private int screenLayerLevel;
    private VisualContext visualContext;

    public NeedDrawObjectAbstractClass() {
        this.visualContext = new VisualContext();
    }

    @Override
    public int getScreenPosX() {
        return screenPosX;
    }

    @Override
    public int getScreenPosY() {
        return screenPosY;
    }

    @Override
    public void setScreenSize(int size) {
        this.screenSize = size;
    }

    @Override
    public int getScreenSize() {
        return screenSize;
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
