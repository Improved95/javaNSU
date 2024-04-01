package org.lab3.observers;

import org.lab3.model.objects.DrawObject;
import org.lab3.slashBlade.JFrameObject;

public interface ViewObserver {
    void addDrawObject(DrawObject drawObject);
    void removeDrawObject(DrawObject drawObject);
    void updateViewScreen(JFrameObject JFrame);
}
