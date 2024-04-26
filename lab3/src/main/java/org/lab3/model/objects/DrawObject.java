package org.lab3.model.objects;

import java.awt.image.BufferedImage;

public interface DrawObject {
    double getScreenPosX();

    void setScreenPosX(double screenPosX);

    double getScreenPosY();

    void setScreenPosY(double screenPosY);

    int getScreenHorizontalDirection();

    void setScreenHorizontalDirection(int horizontalDirection);

    boolean isDrawImageOnMiddle();

    void setDrawImageOnMiddle(boolean drawImageOnMiddle);

    int getScreenLayerLevel();

    void setScreenLayerLevel(int screenLayerLevel);

    double getScreenSize();

    int getScreenWidth();

    void setScreenWidth(int screenWidth);

    int getScreenHeight();

    void setScreenHeight(int screenHeight);

    BufferedImage getImage();

    void setImage();
}
