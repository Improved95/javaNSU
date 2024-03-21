package org.lab3.model;

public interface NeedDrawObject {
    int getScreenPosX();
    int getScreenPosY();

    void setScreenSize(int size);
    int getScreenSize();

    void setScreenLayerLevel(int levelLayer);
    int getScreenLayerLevel();

    VisualContext getVisualContext();
}
