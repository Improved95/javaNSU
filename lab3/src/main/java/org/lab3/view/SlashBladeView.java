package org.lab3.view;

import org.lab3.model.model.Model;
import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;
import java.util.*;

public class SlashBladeView implements View {
    Model model;

    private LinkedSetDrawObjects drawObjectsList = new LinkedSetDrawObjects(new Comparator<DrawObject>() {
        @Override
        public int compare(DrawObject o1, DrawObject o2) {
            if (o1.getScreenLayerLevel() - o2.getScreenLayerLevel() == 0) {
                return -1;
            }
            return o1.getScreenLayerLevel() - o2.getScreenLayerLevel();
        }
    });

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void changeViewScreen(JFrameObject jFrameObject) {
        jFrameObject.repaintObjects();
    }

    @Override
    public void drawObject(Graphics2D g2, FrameSize frameSize) {
        for (DrawObject drawObject : drawObjectsList) {
            EditedImage imageEditor = new EditedImage(drawObject, frameSize);
            g2.drawImage(imageEditor.getNewImage(), (int)imageEditor.getNewPosX(), (int)imageEditor.getNewPosY(),
                    drawObject.getScreenHorizontalDirection() * imageEditor.getNewImage().getWidth(), imageEditor.getNewImage().getHeight(), null);
        }
    }
}
