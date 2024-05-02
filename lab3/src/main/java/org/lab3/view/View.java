package org.lab3.view;

import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.swing.JFrameObject;

import java.awt.*;

public interface View {
    void setModel(Model model);

    void setDrawing(boolean drawing);

    void changeViewScreen(JFrameObject jFrameObject);

    void switchGameStateResources();

    void drawObject(Graphics g);
}
