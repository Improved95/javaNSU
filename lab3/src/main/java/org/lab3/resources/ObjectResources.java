package org.lab3.resources;

import java.awt.image.BufferedImage;

public interface ObjectResources {
    void openResource(String path);

    BufferedImage[][] getImage();
}
