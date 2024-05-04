package org.lab3.view.swing;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.model.objects.characters.slashBlade.FrameSize;
import org.lab3.view.View;

import javax.swing.*;

public interface JFrameObject {
    void addDrawableComponent(View view, KeyListenerController keyListenerController);

    void repaintObjects();

    JFrame getJFrame();

    FrameSize getFrameSize();
}
