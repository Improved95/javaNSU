package org.lab3.resources;

import java.awt.image.BufferedImage;

public interface ObjectResources {
    void openResource(String path);
    void addImage(int i1, int i2, String path);

    BufferedImage[][] getImage();
}
