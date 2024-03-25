package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.observers.ViewObserver;

import java.awt.*;

public interface View extends ViewObserver {
    void change(Model slashBladeModel);
    void drawObject(Graphics2D g2, int screenHeight);
}
