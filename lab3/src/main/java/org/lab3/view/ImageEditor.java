package org.lab3.view;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageEditor {
    public BufferedImage resizingImage(BufferedImage originalImage, int newWidth, int newHeight) {
        return Scalr.resize(originalImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_HEIGHT,
                newWidth, newHeight, Scalr.OP_ANTIALIAS);
    }
}
