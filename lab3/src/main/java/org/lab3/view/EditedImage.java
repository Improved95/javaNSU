package org.lab3.view;

import org.imgscalr.Scalr;
import org.lab3.model.NeedDrawObject;

import java.awt.image.BufferedImage;

public class EditedImage {
    private NeedDrawObject oldImage;
    private BufferedImage newImage;
    private double newPosX = 0;
    private double newPosY = 0;

    public EditedImage(NeedDrawObject oldImage, int screenHeight) {
        this.oldImage = oldImage;
        resizingImage();
        replaceImage(screenHeight);
    }

    public double getNewPosX() {
        return newPosX;
    }

    public double getNewPosY() {
        return newPosY;
    }

    public BufferedImage getNewImage() {
        return newImage;
    }

    public void resizingImage() {
        double newSize = oldImage.getScreenSize() / 100;
        int oldImageWidth = oldImage.getVisualContext().getImage().getWidth();

        int oldImageHeight = oldImage.getVisualContext().getImage().getHeight();

        int newImageWidth = (int)(oldImageWidth * newSize);
        int newImageHeight = (int)(oldImageHeight * newSize);

        this.newImage = Scalr.resize(oldImage.getVisualContext().getImage(), Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                newImageWidth, newImageHeight, Scalr.OP_ANTIALIAS);

    }

    public void replaceImage(int screenHeight) {
        newPosX += oldImage.getScreenPosX();
        newPosY += screenHeight - 39 - newImage.getHeight() - oldImage.getScreenPosY();
    }
}
