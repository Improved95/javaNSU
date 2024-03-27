package org.lab3.model;

public interface NeedDrawObject {
    double getScreenPosX();
    double getScreenPosY();

    void setScreenSize(int size);
    double getScreenSize();

    void setScreenLayerLevel(int levelLayer);
    int getScreenLayerLevel();

    VisualContext getVisualContext();
}
