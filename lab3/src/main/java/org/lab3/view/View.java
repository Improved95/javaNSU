package org.lab3.view;

import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.awt.*;

public interface View {
    void setModel(Model model);

    void changeViewScreen(JFrameObject jFrameObject);
    void drawObject(Graphics2D g2, FrameSize frameSize);
}
