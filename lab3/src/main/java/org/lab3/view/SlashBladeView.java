package org.lab3.view;

import org.lab3.model.model.Model;
import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.openedResources.Level1Resources;
import org.lab3.view.openedResources.OpenedResources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class SlashBladeView implements View {
    private Model model;
    private boolean drawing = false;
    private OpenedResources openedResources;

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
    public void switchGameStateResources() {
        switch (model.getGameState()) {
            case LEVEL1:
                openedResources = new Level1Resources();
                break;
            case MENU:
                break;
        }
    }

    @Override
    public void drawObject(Graphics g, FrameSize frameSize) {
        if (drawing) {
            List<DrawObject> drawObjectsList = new ArrayList<>(model.getGameModeObjectsContext().getDrawObjectsList());
            drawObjectsList.sort((o1, o2) -> {
                if (o1.getScreenLayerLevel() - o2.getScreenLayerLevel() == 0) {
                    return -1;
                }
                return o1.getScreenLayerLevel() - o2.getScreenLayerLevel();
            });

            for (DrawObject drawObject : drawObjectsList) {
                EditedImage.editImage(drawObject, frameSize);
//                BufferedImage image = openedResources.getResourcesList().get(drawObject.getResourcesIndexInResourcesList())
//                        .getOpenedResourcesList().get(drawObject.getCurrentImageIndex()).getOpenedImage();

                BufferedImage image = openedResources.getResourcesList().get(drawObject.getResourcesIndexInResourcesList()).
                        getImage()[drawObject.getCurrentImageIndex().getI1()][drawObject.getCurrentImageIndex().getI2()];

                g.drawImage(image, (int)EditedImage.newPosX, (int)EditedImage.newPosY,
                        EditedImage.newWidth, drawObject.getScreenHeight(), null);
            }
        }
    }
}
