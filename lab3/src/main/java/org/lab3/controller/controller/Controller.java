package org.lab3.controller.controller;

import org.lab3.model.model.Model;
import org.lab3.slashBlade.JFrameObject;
import org.lab3.view.View;

public interface Controller {
    void setJFrameObject(JFrameObject jFrameObject);

    void setModel(Model model);
    void setView(View view);
    void initial();
}
