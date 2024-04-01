package org.lab3.slashBlade;

import org.lab3.controller.keysListener.KeyListenerController;
import org.lab3.view.View;

public interface JFrameObject {
    void addDrawableComponent(View view, KeyListenerController keyListenerController);

    void repaintObjects();

    FrameSize getFrameSize();
}
