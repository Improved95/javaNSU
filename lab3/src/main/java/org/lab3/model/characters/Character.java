package org.lab3.model.characters;

public abstract class Character implements SlashBladeCharacter {
    private int posX;
    private int posY;

    @Override
    public void changePosition(int x, int y) {
        this.posX += x;
        this.posY += y;
    }
}
