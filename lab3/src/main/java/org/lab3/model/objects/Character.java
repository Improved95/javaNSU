package org.lab3.model.objects;

import org.lab3.model.NeedDrawObject;
import org.lab3.model.VisualContext;

public abstract class Character implements SlashBladeCharacter, NeedDrawObject {
    private int posX;
    private int posY;
    private int size;
    private VisualContext visualContext;

    @Override
    public void changePosition(int x, int y) {
        this.posX += x;
        this.posY += y;
    }

    @Override
    public void changeSize(int size) {
        this.size += size;
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
    public int getSize() {
        return size;
    }

    @Override
    public VisualContext getVisualContext() {
        return visualContext;
    }
}
