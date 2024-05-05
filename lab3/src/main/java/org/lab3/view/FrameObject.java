package org.lab3.view;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

import javax.swing.*;

public interface FrameObject {
    void setFrameSize(FrameSize frameSize);

    void addInputListeners(KeyListenerController keyListenerController);

    void repaintObjects();

    void close();
}
