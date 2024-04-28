package org.lab3.model.objects;

public interface SlashBladeObject {
    double getInGamePosX();

    void setInGamePosX(double inGamePosX);

    double getInGamePosY();

    void setInGamePosY(double inGamePosY);

    void setInGamePosition(double x, double y);

    void changeInGamePosition(double dx, double dy);

    int getInGameHorizontalDirection();

    void setInGameHorizontalDirection(int inGameHorizontalDirection);

    void changeDirection(int direction);

    double getObjectSize();

    void setObjectSize(double screenSize);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    boolean isGameObjectIsExist();

    void setGameObjectIsExist(boolean gameObjectIsExist);

    double getCurrentSpeedX();

    void setCurrentSpeedX(double currentSpeedX);

    double getCurrentSpeedY();

    void setCurrentSpeedY(double currentSpeedY);
}
