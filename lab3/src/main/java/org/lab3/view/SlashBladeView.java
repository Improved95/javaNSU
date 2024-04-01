package org.lab3.view;

import org.lab3.model.NeedDrawObject;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;
import java.util.*;

public class SlashBladeView extends ViewObserverAbstract {
    private LinkedSetDrawObjects drawObjectsList = new LinkedSetDrawObjects(new Comparator<NeedDrawObject>() {
        @Override
        public int compare(NeedDrawObject o1, NeedDrawObject o2) {
            if (o1.getScreenLayerLevel() - o2.getScreenLayerLevel() == 0) {
                return -1;
            }
            return o1.getScreenLayerLevel() - o2.getScreenLayerLevel();
        }
    });

    @Override
    public void updateViewScreen(JFrameObject jFrameObject) {
        changeViewScreen(jFrameObject);
    }

    /*@Override
    public void updateDrawList(Model model) {
        GameMode gameMode = model.getCurrentGameMode();
        gameMode.getDrawObjectsList(drawObjectsList);
    }*/

    @Override
    public void addDrawObject(NeedDrawObject drawObject) {
        drawObjectsList.add(drawObject);
    }

    @Override
    public void removeDrawObject(NeedDrawObject drawObject) {
        drawObjectsList.remove(drawObject);
    }

    @Override
    public void changeViewScreen(JFrameObject jFrameObject) {
        jFrameObject.repaintObjects();
    }

    @Override
    public void drawObject(Graphics2D g2, FrameSize frameSize) {
        for (NeedDrawObject drawObject : drawObjectsList) {
            EditedImage imageEditor = new EditedImage(drawObject, frameSize);
            g2.drawImage(imageEditor.getNewImage(), (int)imageEditor.getNewPosX(), (int)imageEditor.getNewPosY(),
                    drawObject.getHorizontalDirection() * imageEditor.getNewImage().getWidth(), imageEditor.getNewImage().getHeight(), null);
        }
    }
}
