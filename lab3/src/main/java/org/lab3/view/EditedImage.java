package org.lab3.view;

import org.imgscalr.Scalr;
import org.lab3.model.NeedDrawObject;
import org.lab3.slashBlade.FrameSize;

import java.awt.image.BufferedImage;

public class EditedImage {
    private NeedDrawObject oldImage;
    private BufferedImage newImage;
    private double newPosX = 0;
    private double newPosY = 0;

    public EditedImage(NeedDrawObject oldImage, FrameSize frameSize) {
        this.oldImage = oldImage;
        resizingImage(frameSize);
        replaceImage(frameSize);
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

    public void resizingImage(FrameSize frameSize) {
        int oldImageWidth = oldImage.getVisualContext().getImage().getWidth();
        int oldImageHeight = oldImage.getVisualContext().getImage().getHeight();

        double newSize = oldImage.getScreenSize() / 100;
        double newNativeImageWidth = oldImageWidth * newSize;
        double newNativeImageHeight = oldImageHeight * newSize;

        double newImageWidthByScreenSize = newNativeImageWidth * frameSize.getReductionFactor();
        double newImageHeightByScreenSize = newNativeImageHeight * frameSize.getReductionFactor();

        this.newImage = Scalr.resize(oldImage.getVisualContext().getImage(), Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                (int)newImageWidthByScreenSize, (int)newImageHeightByScreenSize, Scalr.OP_ANTIALIAS);

    }

    public void replaceImage(FrameSize frameSize) {
        if (oldImage.isDrawImageOnMiddle()) {
            newPosX -= (newImage.getWidth() * oldImage.getHorizontalDirection()) / 2;
        }
        newPosX += oldImage.getScreenPosX();
        newPosY += frameSize.getHeight() - (  39 + newImage.getHeight() + ( oldImage.getScreenPosY() * frameSize.getReductionFactor() ) );
    }
}
