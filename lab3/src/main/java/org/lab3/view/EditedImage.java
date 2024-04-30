package org.lab3.view;

import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;

public class EditedImage {
    public static double newPosX;
    public static int newWidth;

    public static void editImage(DrawObject oldImage) {
        replaceImage(oldImage);
    }

    private static void replaceImage(DrawObject oldImage) {
        newPosX = 0;
        if (oldImage.getScreenHorizontalDirection() == -1) {
            newPosX += oldImage.getScreenWidth();
        }
        newWidth = oldImage.getScreenWidth() * oldImage.getScreenHorizontalDirection();
        newPosX += oldImage.getScreenPosX();
    }
}
