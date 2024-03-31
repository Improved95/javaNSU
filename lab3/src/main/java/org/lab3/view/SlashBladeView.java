package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SlashBladeView extends ViewObserverAbstract {
    private Set<NeedDrawObject> drawObjectsList = new TreeSet<>(new Comparator<NeedDrawObject>() {
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

    @Override
    public void updateDrawList(Model model) {
        drawObjectsList.clear();
        GameMode gameMode = model.getCurrentGameMode();
        gameMode.getDrawObjectsList(drawObjectsList);
    }

    @Override
    public void changeViewScreen(JFrameObject jFrameObject) {
        jFrameObject.repaintObjects();
    }

    @Override
    public void drawObject(Graphics2D g2, FrameSize frameSize) {
        Iterator<NeedDrawObject> iterator = drawObjectsList.iterator();
        while (iterator.hasNext()) {
            NeedDrawObject drawObject = iterator.next();
            EditedImage imageEditor = new EditedImage(drawObject, frameSize);
            g2.drawImage(imageEditor.getNewImage(), (int)imageEditor.getNewPosX(), (int)imageEditor.getNewPosY(),
                    drawObject.getHorizontalDirection() * imageEditor.getNewImage().getWidth(), imageEditor.getNewImage().getHeight(), null);
        }
        /*for (NeedDrawObject drawObject : drawObjectsList) {
            EditedImage imageEditor = new EditedImage(drawObject, frameSize);
            g2.drawImage(imageEditor.getNewImage(), (int)imageEditor.getNewPosX(), (int)imageEditor.getNewPosY(),
                    drawObject.getHorizontalDirection() * imageEditor.getNewImage().getWidth(), imageEditor.getNewImage().getHeight(), null);
        }*/
    }
}
