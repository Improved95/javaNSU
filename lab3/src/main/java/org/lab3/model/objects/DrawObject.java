package org.lab3.model.objects;

import java.awt.image.BufferedImage;

public interface DrawObject {
    double getScreenPosX();

    void setScreenPosX(double screenPosX);

    double getScreenPosY();

    void setScreenPosY(double screenPosY);

    double getScreenSize();

    void setScreenSize(double screenSize);

    int getHorizontalDirection();

    void setHorizontalDirection(int horizontalDirection);

    boolean isDrawImageOnMiddle();

    void setDrawImageOnMiddle(boolean drawImageOnMiddle);

    int getScreenLayerLevel();

    void setScreenLayerLevel(int screenLayerLevel);

    BufferedImage getImage();

    void setImage(BufferedImage image);
}
