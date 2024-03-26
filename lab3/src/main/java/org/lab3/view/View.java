package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.observers.ViewObserver;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;

public interface View extends ViewObserver {
    void changeViewScreen(JFrameObject jFrameObject);
    void drawObject(Graphics2D g2, int screenHeight);
}
