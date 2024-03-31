package org.lab3.observers;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.slashBlade.JFrameObject;

public interface ViewObserver {
    void addDrawObject(NeedDrawObject drawObject);
    void removeDrawObject(NeedDrawObject drawObject);
    void updateViewScreen(JFrameObject JFrame);
}
