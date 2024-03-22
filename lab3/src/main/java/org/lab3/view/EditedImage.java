package org.lab3.view;

import org.imgscalr.Scalr;
import org.lab3.model.NeedDrawObject;

import java.awt.image.BufferedImage;

public class EditedImage {
    private NeedDrawObject oldImage;
    private BufferedImage newImage;
    private int newPosX;
    private int newPosY;

    public EditedImage(NeedDrawObject oldImage) {
        this.oldImage = oldImage;
    }

    public int getNewPosX() {
        return newPosX;
    }

    public int getNewPosY() {
        return newPosY;
    }

    public BufferedImage getNewImage() {
        return newImage;
    }

    public void resizingImage() {
        double newSize = oldImage.getScreenSize() / (double)100;
        int oldImageWidth = oldImage.getVisualContext().getImage().getWidth();
        int oldImageHeight = oldImage.getVisualContext().getImage().getHeight();

        int newImageWidth = (int)(oldImageWidth * newSize);
        int newImageHeight = (int)(oldImageHeight * newSize);

        this.newImage = Scalr.resize(oldImage.getVisualContext().getImage(), Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                newImageWidth, newImageHeight, Scalr.OP_ANTIALIAS);
    }

    public void replaceImage(int screenHeight) {
        newPosX = oldImage.getScreenPosX();
        newPosY = screenHeight - oldImage.getVisualContext().getImage().getHeight() - oldImage.getScreenPosY();
//        newPosY = screenHeight - newImage.getHeight() - oldImage.getScreenPosY();
    }
}
