package org.lab3.controller.gameMode;

import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.LinkedSetDrawObjects;


public interface GameMode {
    void initial();

    void execute(double currentFPS, FrameSize frameSize);

    void actionOnKeyPressed(int keyCode);

    void actionOnKeyReleased(int keyCode);

    void actionOnMousePressed(int mouseKeyCode);
}
