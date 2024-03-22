package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;
import org.lab3.slashBlade.JFrameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class SlashBladeView implements View {
    @Override
    public void change(Model slashBladeModel, JFrameObject jFrameObject) throws IllegalAccessException {
        GameMode gameMode = slashBladeModel.getCurrentGameMode();
        Set<NeedDrawObject> drawObjectsList = gameMode.getDrawObjectsList();
        jFrameObject.getJFrame().add(new MyComponent(drawObjectsList, jFrameObject.getScreenHeight()));
    }
}

class MyComponent extends JComponent {
    private Set<NeedDrawObject> drawObjectsList;
    private int screenHeight;

    public MyComponent(Set<NeedDrawObject> drawObjectsList, int screenHeight) {
        this.drawObjectsList = drawObjectsList;
        this.screenHeight = screenHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        for (NeedDrawObject drawObject : drawObjectsList) {
            EditedImage imageEditor = new EditedImage(drawObject, screenHeight);
            g2.drawImage(imageEditor.getNewImage(), imageEditor.getNewPosX(), imageEditor.getNewPosY(), null);
        }
    }
}
