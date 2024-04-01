package org.lab3.controller.controller;

import org.lab3.model.Model;
import org.lab3.view.View;

public interface Controller {
    void setSlashBladeModel(Model slashBladeModel);
    void setSlashBladeView(View slashBladeView);
    void initial();
}
