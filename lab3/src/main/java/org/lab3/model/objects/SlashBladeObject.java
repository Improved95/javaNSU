package org.lab3.model.objects;

public interface SlashBladeObject {
    double getInGamePosX();

    void setInGamePosX(double inGamePosX);

    double getInGamePosY();

    void setInGamePosY(double inGamePosY);

    void changeInGamePos(double dx, double dy);
}
