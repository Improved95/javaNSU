package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;

public abstract class ViewObserverAbstract implements View {
    @Override
    public void updateViewScreen(JFrameObject JFrame) {

    }

    @Override
    public void changeViewScreen(JFrameObject JFrame) {

    }

    @Override
    public void drawObject(Graphics2D g2, int screenWidth, int screenHeight) {

    }

    @Override
    public void updateDrawList(Model model) {

    }
}
