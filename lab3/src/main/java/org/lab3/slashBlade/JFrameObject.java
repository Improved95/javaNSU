package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.view.View;

public interface JFrameObject {
    void addDrawableComponent(View view, Controller controller);
    void repaintObjects();
}
