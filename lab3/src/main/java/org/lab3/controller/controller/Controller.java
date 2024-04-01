package org.lab3.controller.controller;

import org.lab3.model.Model;
import org.lab3.view.View;

public interface Controller {
    void setModel(Model model);
    void setView(View view);
    void initial();
}
