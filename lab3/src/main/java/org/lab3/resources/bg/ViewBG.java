package org.lab3.resources.bg;

import java.awt.image.BufferedImage;

public interface ViewBG extends AutoCloseable {
    BufferedImage getImage();

    @Override
    void close() throws Exception;
}
