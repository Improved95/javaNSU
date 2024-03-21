package org.lab3.view;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageEditor {
    public BufferedImage resizingImage(BufferedImage originalImage, int newWidth, int newHeight, int size) {
        return Scalr.resize(originalImage, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC,
                newWidth * size / 100, newHeight * size / 100, Scalr.OP_ANTIALIAS);
    }
}
