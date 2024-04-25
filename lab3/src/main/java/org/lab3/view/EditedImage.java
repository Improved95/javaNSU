package org.lab3.view;

import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;

public class EditedImage {
    public static double newPosX;
    public static double newPosY;
    public static int newImageWidth;
    public static int newImageHeight;

    public static void editImage(DrawObject oldImage, FrameSize frameSize) {
        resizingImage(oldImage, oldImage.getScreenSize());
        replaceImage(oldImage, frameSize);
    }

    private static void resizingImage(DrawObject oldImage, double screenSize) {
        int oldImageWidth = oldImage.getImage().getWidth();
        int oldImageHeight = oldImage.getImage().getHeight();

        double newSize = screenSize / 100;
        newImageWidth = (int)(oldImageWidth * newSize * oldImage.getScreenHorizontalDirection());
        newImageHeight = (int)(oldImageHeight * newSize);
    }

    private static void replaceImage(DrawObject oldImage, FrameSize frameSize) {
        newPosX = 0;
        newPosY = 0;
        if (oldImage.isDrawImageOnMiddle()) {
            newPosX -= (newImageWidth * oldImage.getScreenHorizontalDirection() * oldImage.getScreenHorizontalDirection()) / 2;
        }
        newPosX += oldImage.getScreenPosX();
        newPosY += frameSize.getHeight() - (  39 + newImageHeight + ( oldImage.getScreenPosY() * frameSize.getReductionFactor() ) );
    }
}
