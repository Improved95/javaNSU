package org.lab3.view;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

import javax.swing.*;

public interface FrameObject {
    void addDrawableComponent(View view, KeyListenerController keyListenerController);

    void repaintObjects();

    FrameSize getFrameSize();

    void close();
}
