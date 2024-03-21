package org.lab3.model;

public abstract class NeedDrawObjectAbstractClass implements NeedDrawObject {
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
    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public int getScreenLevelLayer() {
        return 0;
    }

    @Override
    public VisualContext getVisualContext() {
        return visualContext;
    }
}
