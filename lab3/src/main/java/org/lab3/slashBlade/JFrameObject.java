package org.lab3.slashBlade;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.view.View;

import javax.swing.*;

public interface JFrameObject {
    void addDrawableComponent(View view, KeyListenerController keyListenerController);

    void repaintObjects();

    JFrame getJFrame();

    FrameSize getFrameSize();
}
