package org.lab3.controller.controller;

import org.lab3.model.model.Model;
import org.lab3.view.FrameObject;
import org.lab3.view.View;

public interface Controller {
    void setJFrameObject(FrameObject frameObject);

    void setModel(Model model);
    void setView(View view);
    void initial();

    void executeCalculateGame();

    KeyListenerController getSlashBladeKeyListenerController();
}
