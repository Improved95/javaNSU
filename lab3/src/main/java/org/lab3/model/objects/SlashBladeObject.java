package org.lab3.model.objects;

public interface SlashBladeObject {
    void setInGamePosition(int x, int y);
    void changeInGamePosition(int x, int y);
    int getInGamePosX();
    int getInGamePosY();
}
