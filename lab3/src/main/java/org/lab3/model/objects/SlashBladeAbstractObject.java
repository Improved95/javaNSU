package org.lab3.model.objects;

import org.lab3.model.VisualContext;

public class SlashBladeAbstractObject implements SlashBladeObject {
    private int posX;
    private int posY;
    private int size;
    private VisualContext visualContext;

    @Override
    public void setPosition(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void changePosition(int x, int y) {
        this.posX += x;
        this.posY += y;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public void changeSize(int size) {
        this.size += size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public VisualContext getVisualContext() {
        return visualContext;
    }
}
