package org.lab3.view;

import org.lab3.model.model.Model;

import java.awt.*;

public interface View {
    void setModel(Model model);

    void switchGameStateResources();
}
