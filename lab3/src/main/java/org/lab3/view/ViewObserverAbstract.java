package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.slashBlade.FrameSize;
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
    public void drawObject(Graphics2D g2, FrameSize frameSize) {

    }

    @Override
    public void addDrawObject(NeedDrawObject drawObject) {

    }

    @Override
    public void removeDrawObject(NeedDrawObject drawObject) {

    }
}
