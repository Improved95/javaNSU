package org.lab3.model.objects;

import org.lab3.view.resources.ImageIndex;

public interface DrawObject {
    double getScreenPosX();

    void setScreenPosX(double screenPosX);

    double getScreenPosY();

    void setScreenPosY(double screenPosY);

    int getScreenHorizontalDirection();

    void setScreenHorizontalDirection(int horizontalDirection);

    int getScreenLayerLevel();

    void setScreenLayerLevel(int screenLayerLevel);

    double getScreenSize();

    int getScreenWidth();

    void setScreenWidth(int screenWidth);

    int getScreenHeight();

    void setScreenHeight(int screenHeight);

    int getResourcesIndexInResourcesList();

    void setResourcesIndexInResourcesList(int resourcesIndexInResourcesList);

    ImageIndex getCurrentImageIndex();

    void setCurrentImageIndex(int i1, int i2);
}
