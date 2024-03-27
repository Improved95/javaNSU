package org.lab3.model.objects;

public interface SlashBladeObject {
    void setInGamePosition(double x, double y);
    void changeInGamePosition(double x, double y);
    double getInGamePosX();
    double getInGamePosY();
}
