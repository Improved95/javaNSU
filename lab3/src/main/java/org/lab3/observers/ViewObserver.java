package org.lab3.observers;

import org.lab3.model.Model;
import org.lab3.slashBlade.JFrameObject;

public interface ViewObserver {
    void updateDrawList(Model model);
    void updateViewScreen(JFrameObject JFrame);
}
