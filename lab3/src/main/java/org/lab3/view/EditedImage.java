package org.lab3.view;

import org.imgscalr.Scalr;
import org.lab3.model.NeedDrawObject;

import java.awt.image.BufferedImage;

public class EditedImage {
    private NeedDrawObject oldImage;
    private BufferedImage newImage;
    private double newPosX = 0;
    private double newPosY = 0;

    public EditedImage(NeedDrawObject oldImage, int screenWidth, int screenHeight) {
        this.oldImage = oldImage;
        resizingImage(screenWidth, screenHeight);
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

    public void resizingImage(int screenWidth, int screenHeight) {
        int oldImageWidth = oldImage.getVisualContext().getImage().getWidth();
        int oldImageHeight = oldImage.getVisualContext().getImage().getHeight();

        double newSize = oldImage.getScreenSize() / 100;
        double newNativeImageWidth = oldImageWidth * newSize;
        double newNativeImageHeight = oldImageHeight * newSize;

        double newImageWidthByScreenSize = newNativeImageWidth * ((double)screenWidth / 1920);
        double newImageHeightByScreenSize = newNativeImageHeight * ((double)screenHeight / 1080);

        this.newImage = Scalr.resize(oldImage.getVisualContext().getImage(), Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                (int)newImageWidthByScreenSize, (int)newImageHeightByScreenSize, Scalr.OP_ANTIALIAS);

    }

    public void replaceImage(int screenHeight) {
        if (oldImage.isDrawImageOnMiddle()) {
            newPosX -= (newImage.getWidth() * oldImage.getHorizontalDirection()) / 2;
        }
        newPosX += oldImage.getScreenPosX();
        newPosY += screenHeight - ( ( 37 * ((double)screenHeight / 1080) ) + newImage.getHeight() + ( oldImage.getScreenPosY() * ((double)screenHeight / 1080) ) );
    }
}
