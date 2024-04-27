package org.lab3.controller.gameMode;

import org.lab3.slashBlade.FrameSize;


public interface GameMode {
    void initial();

    int execute(double currentFPS);

    void actionOnKeyPressed(int keyCode);

    void actionOnKeyReleased(int keyCode);

    void actionOnMousePressed(int mouseKeyCode);

    void reset();
}
