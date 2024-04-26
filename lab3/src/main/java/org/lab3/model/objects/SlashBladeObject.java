package org.lab3.model.objects;

public interface SlashBladeObject {
    double getInGamePosX();

    void setInGamePosX(double inGamePosX);

    double getInGamePosY();

    void setInGamePosY(double inGamePosY);

    void setInGamePosition(double x, double y);

    void changeInGamePos(double dx, double dy);

    double getObjectSize();

    void setObjectSize(double screenSize);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    boolean isGameObjectIsExist();

    void setGameObjectIsExist(boolean gameObjectIsExist);
}
