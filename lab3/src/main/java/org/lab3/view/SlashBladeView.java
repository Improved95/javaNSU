package org.lab3.view;

import org.lab3.model.model.Model;
import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SlashBladeView implements View {
    private Model model;
    private boolean drawing = false;

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }

    @Override
    public void changeViewScreen(JFrameObject jFrameObject) {
        jFrameObject.repaintObjects();
    }

    @Override
    public void drawObject(Graphics2D g2, FrameSize frameSize) {
        if (drawing) {
            List<DrawObject> drawObjectsList = new ArrayList<>(model.getGameModeObjectsContext().getDrawObjectsList());
            drawObjectsList.sort((o1, o2) -> {
                if (o1.getScreenLayerLevel() - o2.getScreenLayerLevel() == 0) {
                    return -1;
                }
                return o1.getScreenLayerLevel() - o2.getScreenLayerLevel();
            });

            for (DrawObject drawObject : drawObjectsList) {
                EditedImage imageEditor = new EditedImage(drawObject, frameSize);
                g2.drawImage(imageEditor.getNewImage(), (int)imageEditor.getNewPosX(), (int)imageEditor.getNewPosY(),
                        drawObject.getScreenHorizontalDirection() * imageEditor.getNewImage().getWidth(), imageEditor.getNewImage().getHeight(), null);
            }
        }
    }
}
