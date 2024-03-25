package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;

public abstract class ViewObserverAbstract implements View {
    @Override
    public void update(Model model, JFrameObject slashBladeJFrame) {}

    @Override
    public void change(Model slashBladeModel, JFrameObject slashBladeJFrame) {

    }

    @Override
    public void drawObject(Graphics2D g2, int screenHeight) {

    }
}
