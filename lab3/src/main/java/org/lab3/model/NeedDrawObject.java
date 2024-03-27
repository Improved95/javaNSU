package org.lab3.model;

public interface NeedDrawObject {
    double getScreenPosX();
    double getScreenPosY();

    void setHorizontalDirection(int horizontalDirection);
    int getHorizontalDirection();

    void setScreenSize(double size);
    double getScreenSize();


    void setDrawImageOnMiddle(boolean drawImageOnMiddle);

    boolean isDrawImageOnMiddle();

    void setScreenLayerLevel(int levelLayer);
    int getScreenLayerLevel();

    VisualContext getVisualContext();
}
