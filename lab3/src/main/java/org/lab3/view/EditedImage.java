package org.lab3.view;

import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;

public class EditedImage {
    public static double newPosX;
    public static double newPosY;
    public static int newWidth;

    public static void editImage(DrawObject oldImage, FrameSize frameSize) {
        replaceImage(oldImage, frameSize);
    }

    private static void replaceImage(DrawObject oldImage, FrameSize frameSize) {
        newPosX = 0;
        newPosY = 0;
        if (oldImage.getScreenHorizontalDirection() == -1) {
            newPosX += oldImage.getScreenWidth();
        }
        newWidth = oldImage.getScreenWidth() * oldImage.getScreenHorizontalDirection();
        newPosX += oldImage.getScreenPosX();
        newPosY += frameSize.getHeight() - (  39 + oldImage.getScreenHeight() + ( oldImage.getScreenPosY() * frameSize.getReductionFactor() ) );
    }
}
