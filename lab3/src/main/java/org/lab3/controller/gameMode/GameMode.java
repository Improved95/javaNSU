package org.lab3.controller.gameMode;

import org.lab3.slashBlade.FrameSize;


public interface GameMode {
    void initial();

    void execute(double currentFPS, FrameSize frameSize);

    void actionOnKeyPressed(int keyCode);

    void actionOnKeyReleased(int keyCode);

    void actionOnMousePressed(int mouseKeyCode);
}
