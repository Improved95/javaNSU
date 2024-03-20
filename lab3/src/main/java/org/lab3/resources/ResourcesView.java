package org.lab3.resources;

import java.awt.image.BufferedImage;

public interface ResourcesView extends AutoCloseable {
    BufferedImage getImage();

    @Override
    void close() throws Exception;
}
